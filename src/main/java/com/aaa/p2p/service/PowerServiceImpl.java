package com.aaa.p2p.service;

import com.aaa.p2p.dao.PowerDao;
import com.aaa.p2p.entity.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * className:PowerServiceImpl
 * discription:
 * author:luRuiHua
 * createTime:2018-12-07 17:55
 */
@Service
public class PowerServiceImpl implements PowerService {
    @Autowired
    private PowerDao powerDao;

    /**
     * 获取员工的角色id
     * @param httpSession
     * @return
     */
    public Integer getRoleId(HttpSession httpSession) {
        Map map = (Map)httpSession.getAttribute("emp");
        return Integer.valueOf(map.get("ROLEID")+"");
    }

    public List<TreeNode> getList(HttpSession httpSession){
        //获取员工的角色id
        Integer roleId = getRoleId(httpSession);
        //查询数据
        List<Map> powerMapList = powerDao.getPowerList(roleId);
        System.out.println(powerMapList);
        //定义返回列表
        List<TreeNode> powerList = new ArrayList<TreeNode>();
        //判断是否为空
        if(powerMapList!=null&&powerMapList.size()>0){
            TreeNode treeNode = null;
            //循环遍历，构造TreeNode对象，加入powerList
            for(Map powerMap:powerMapList){
                // treeNode = new TreeNode(id, text, parentId, state, iconCls, url);
                //if (powerMap.get("id") != null && powerMap.get("parentid") != null) {
                treeNode = new TreeNode(Integer.valueOf(powerMap.get("ID")+""), powerMap.get("NAME")+"",
                        Integer.valueOf(powerMap.get("PARENTID")+""), powerMap.get("STATE")+""
                        , powerMap.get("ICONCLS")+"", powerMap.get("URL")+"");
                //}
                powerList.add(treeNode);
            }
        }
        return powerList;
    }


    @Override
    public List<TreeNode> getPowerList(HttpSession session) {

        // TODO Auto-generated method stub
        List<TreeNode> powerAllList = getList(session);
        //临时的powerList
        List<TreeNode> powerTempList = new ArrayList<TreeNode>();
        //判断是否为空
        if(powerAllList!=null&&powerAllList.size()>0){
            for(TreeNode ptreeNode:powerAllList){
                if(ptreeNode.getParentId()==0){//如果等于0,说明是一级节点
                    powerTempList.add(ptreeNode);
                    //递归绑定子节点,ptreeNode是所有的父节点
                    bindChirldren(ptreeNode,powerAllList);
                }
            }
        }
        return powerTempList;
    }
    /**
     * 递归绑定所有子节点
     * @param parentTreeNode
     * @param powerAllList
     */
    private  void bindChirldren(TreeNode parentTreeNode,List<TreeNode> powerAllList ){
        for(TreeNode chirldrenTreeNode:powerAllList){
            if(parentTreeNode.getId()==chirldrenTreeNode.getParentId()){
                //获取当前节点的所有子节点集合
                List<TreeNode> children = parentTreeNode.getChildren();
                if(children==null){//如果孩子节点为空,
                    List<TreeNode> childrenTempList = new ArrayList<TreeNode>();//实例化孩子集合
                    childrenTempList.add(chirldrenTreeNode);//添加子节点到集合里面
                    parentTreeNode.setChildren(childrenTempList);//设置孩子集合
                }else{//不空，说明设置过
                    children.add(chirldrenTreeNode);//添加子节点到集合里面
                }
                //自己调用自己,找孩子
                bindChirldren(chirldrenTreeNode,powerAllList);
            }
        }
    }



    /**
     * 毫无理由
     * @return
     */
    @Override
    public List<TreeNode> getPList(){
        //查询数据
        List<Map> powerMapList = powerDao.getPList();
        //定义返回列表
        List<TreeNode> powerList = new ArrayList<TreeNode>();
        //判断是否为空
        if(powerMapList!=null&&powerMapList.size()>0){
            TreeNode treeNode = null;
            //循环遍历，构造TreeNode对象，加入powerList
            for(Map powerMap:powerMapList){
                // treeNode = new TreeNode(id, text, parentId, state, iconCls, url);
                //if (powerMap.get("id") != null && powerMap.get("parentid") != null) {
                treeNode = new TreeNode(Integer.valueOf(powerMap.get("ID")+""), powerMap.get("NAME")+"",
                        Integer.valueOf(powerMap.get("PARENTID")+""), powerMap.get("STATE")+""
                        , powerMap.get("ICONCLS")+"", powerMap.get("URL")+"");
                //}
                powerList.add(treeNode);
            }
        }
        return powerList;
    }

    /**
     * 毫无理由
     * @return
     */
    @Override
    public List<TreeNode> getPPowerList() {

        // TODO Auto-generated method stub
        List<TreeNode> powerAllList = getPList();
        //临时的powerList
        List<TreeNode> powerTempList = new ArrayList<TreeNode>();
        //判断是否为空
        if(powerAllList!=null&&powerAllList.size()>0){
            for(TreeNode ptreeNode:powerAllList){
                if(ptreeNode.getParentId()==0){//如果等于0,说明是一级节点
                    powerTempList.add(ptreeNode);
                    //递归绑定子节点,ptreeNode是所有的父节点
                    bindChirldren(ptreeNode,powerAllList);
                }
            }
        }
        return powerTempList;
    }

    /**
     * 通过pid获取权限列表
     * @return
     */
    public List<Map> selectTreeByPid(Map map){
        return powerDao.selectTreeByPid(map);
    }
    /**
     * 添加节点
     * @param map
     * @return
     */
    public int insertTree(Map map){
        return powerDao.insertTree(map);
    }
    /**
     * 更改节点
     * @param map
     * @return
     */
    public int updateTree(Map map){
        return powerDao.updateTree(map);
    }
    /**
     * 删除节点
     */
    public int deleteTree(Map map){
        return powerDao.deleteTree(map);
    }
}
