package com.aaa.p2p.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:BorrowDao
 * discription:
 * author:mx
 * createTime:2018-12-14 19:37
 */

public interface BorrowDao {
    /**
     * 创表插入
     * @return
     */
    @Insert("insert into tb_bidinfo(userID,id,bidAmount,BIDCURRENTAMOUNT,bidType,bidDeadline,bidDeadDay,bidRate,bidApplyDate,bidDesc,bidRepaymentMethod,bidState)" +
            "values(#{userID},tb_bidinfo_id.nextval,#{bidAmount},0,#{bidType},#{bidDeadline},#{bidDeadDay},#{bidRate},sysdate,#{bidDesc},#{bidRepaymentMethod},'未审核')")
      int insert(Map map);

    /**
     * 查询是否可以投标
     * @param userID
     * @return
     */
    @Select("select * from tb_bidinfo where userID=#{param1} and bidState not in ('流标完成','还款结束','拒绝')")
    List<Map> selectBidIf(int userID);

    /**
     * 查询实名认证是否通过
     * @param userID
     * @return
     */
    @Select("select * from TB_USERREAL where AUDITRESULT='审核通过' and userID=#{param1}")
    List<Map> selectUserReal(String userID);

    /**
     * 查询视频认证是否通过
     * @param userID
     * @return
     */
    @Select("select * from TB_VIDEO_AUDIT where AUDITRESULT='审核通过' and userID=#{param1}")
    List<Map> selectVideo(String userID);
}
