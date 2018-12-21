package com.aaa.p2p.util;

/**
 * className:P2PUtil
 * discription:计算
 * author:luRuiHua
 * createTime:2018-12-21 15:06
 */
public class P2PUtil {
    /**
     * 每月本息和
     * @param benjin Double类型：本金
     * @param lilv Double类型：利率
     * @param months Integer类型：月数
     * @return 每月本息和
     */
    public static Double getMonthTotle(Double benjin, Double lilv, Integer months){
        Double monthTotle = (benjin * lilv * Math.pow((1+lilv), months))/(Math.pow((1+lilv), months)-1);
        return monthTotle;
    }
    /**
     * 总还款利息
     * @param benjin Double类型：本金
     * @param lilv Double类型：利率
     * @param months Integer类型：月数
     * @return 总还款利息
     */
    public static Double getInterestTotle(Double benjin, Double lilv, Integer months){
        Double a = Math.pow((1+lilv), months);
        //还款总利息
        Double inTotle = ((benjin * months * lilv * a)/(a-1))-benjin;
        return inTotle;
    }
    /**
     * 还款总额
     * @param benjin Double类型：本金
     * @param lilv Double类型：利率
     * @param months Integer类型：月数
     * @return 还款总额
     */
    public static Double getTotle(Double benjin, Double lilv, Integer months){
        Double a = Math.pow((1+lilv), months);
        //还款总利息
        Double totle = (benjin * months * lilv * a)/(a-1);
        return totle;
    }
}
