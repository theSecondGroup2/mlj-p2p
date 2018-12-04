package com.aaa.p2p.util;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenerateEntity {

	//设置数据库链接配置
	private static Connection conn;
	private static String CLASSNAME = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql:///new";
	private static String USER = "root";
	private static String PSW = "1229zsy";
	private static String TABLE_SCHEAME = "new";

	//设置实体包名路径配置
	private static String PACKAGE_PATH = "com.aaa.vo";//实体包名路径
	private static String FILE_PATH = "/src/com/aaa/vo/";//实体文件写入路径
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("开始链接数据库....................");
			Class.forName(CLASSNAME);
			conn = (Connection)DriverManager.getConnection(URL,USER,PSW);
			System.out.println("数据库链接成功");
			//从information_schema数据库中的tables表中找出相同数据库名对应的表名
			String sql = "select TABLE_NAME from information_schema.TABLES where TABLE_SCHEMA='" +
					TABLE_SCHEAME + "';";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("开始生成实体..............");
			while(rs.next()) {
				//包路径、创建类、字段属性
				StringBuffer sb = new StringBuffer();
				//set、get函数
				StringBuffer sbf = new StringBuffer();
				//构造方法
				StringBuffer cst1 = new StringBuffer();
				//
				StringBuffer cst2 = new StringBuffer();
				//
				StringBuffer cst3 = new StringBuffer();
				//重写toString函数
				StringBuffer toStr = new StringBuffer();
				sb.append("package " + PACKAGE_PATH + ";\r\n");
				cst1.append("\r\n public " + upperCase(rs.getString(1)) + "() " + "{\n\n}\n "
						+"\r\n public " + upperCase(rs.getString(1)));
				toStr.append("\r\n public String toString() {\n return");
				sb.append("\r\npublic class " + upperCase(rs.getString(1)) + "{\r\n");
				//执行desc语句查询表结构
				ps = conn.prepareStatement("desc " + rs.getString(1));
				ResultSet rsTable =(ResultSet)ps.executeQuery();
				boolean bool =  true;
				int i =1;
				@SuppressWarnings("unused")
				int col = rsTable.getMetaData().getColumnCount();
				while (rsTable.next()) {
					String name = lowerCase(rsTable.getString(1));//字段名
					if("class".equals(name)) {
						name = "nameClass";
					}
					String type = rsTable.getString(2);
					if(type.contains("int") || type.contains("bigInt")) {
						type = "int";
					} else if(type.contains("text") || type.contains("char")) {
						type = "String";
					} else if(type.contains("float")) {
						type = "float";
					} else if(type.contains("decimal") || type.contains("numeric")
							|| type.contains("real") || type.contains("money")
							|| type.contains("smallmoney")) {
						type = "double";
					} else if (type.contains("date") || type.contains("datetime") || type.contains("bit")) {
						if(bool) {
							int a = sb.indexOf("\n");
							sb.insert(a, "\r\nimport java.util.Date;");
							bool = false;
						}
						type = "Date";
					}

					sb.append("\r\n private " + type + " " + name + ";\r\n");
					sbf.append("\r\n public void set"
							+ upperCase(name) + "(" + type + " " + name + ") {");
					sbf.append("\r\n	    this." + name + " = " + name +";\r\n }\r\n");
					sbf.append("\r\n public " + type + " get" + upperCase(name)
							+ "() {\r\n		" + "return " + name + ";\r\n}\r\n");
					if(i == 1) {
						cst2.append(" (" + type + " " + name);
						cst3.append(") {\nthis." + name + " = " + name + ";");
						toStr.append(" \"" + upperCase(rs.getString(1)) + " [" + name
								+ "=\"" + " + " + name + " + ");
					} else {
						toStr.append("\", " + name + "=\" + " + name + " + " );
						cst2.append(", " + type + " " + name );
						cst3.append("\nthis." + name + " = " + name + ";");
					}
					if(i%3 ==  0){
						toStr.append("\n");
					}
					i++;

				}
				cst3.append("\n}");
				toStr.append("\"]\";\n}\n}");
				String entity = sb.toString() +cst1.toString() + cst2.toString() + cst3.toString() + sbf.toString() + toStr.toString();
				System.out.println("写入实体： " + upperCase(rs.getString(1) + "..........."));
				File directory  = new File("");

				String outputPath = directory.getAbsolutePath() + FILE_PATH + upperCase(rs.getString(1)) +
						".java";
				System.out.println(directory.getAbsolutePath() + FILE_PATH + upperCase(rs.getString(1)) +
						".java");
				FileWriter fw = new FileWriter(outputPath);
				PrintWriter pw = new PrintWriter(fw);
				//打印包含字段、方法的字符串
				pw.println(entity);
				//刷新该流
				pw.flush();
				pw.close();
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String upperCase(String str) {
		//首字母大写
		return str.substring(0,1).toUpperCase() + str.substring(1);
	}

	public static String lowerCase(String str) {
		//首字母小写
		return str.substring(0,1).toLowerCase() + str.substring(1);
	}


}





