package com.aaa.p2p.dao;

import org.apache.ibatis.annotations.Insert;

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
    @Insert("insert into tb_bidinfo(userID,id,bidAmount,bidType,bidDeadline,bidDeadDay,bidRate,bidApplyDate,bidDesc,bidRepaymentMethod,bidState)" +
            "values(1,tb_bidinfo_id.nextval,#{bidAmount},#{bidType},#{bidDeadline},#{bidDeadDay},#{bidRate},sysdate,#{bidDesc},#{bidRepaymentMethod},'未审核')")
      int insert(Map map);

}
