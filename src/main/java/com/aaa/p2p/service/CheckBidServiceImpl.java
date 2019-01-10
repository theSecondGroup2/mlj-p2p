package com.aaa.p2p.service;

import com.aaa.p2p.dao.BidAudit;
import com.aaa.p2p.dao.CheckBidDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:CheckBidServiceImpl
 * discription:
 * author:luRuiHua
 * createTime:2018-12-14 15:23
 */
@Service
public class CheckBidServiceImpl implements CheckBidService {
    @Autowired
    private CheckBidDao checkBidDao;
    @Autowired
    private BidAudit bidAudit;

    /**
     * 查询标的信息列表
     *
     * @param map
     * @return
     */
    @Override
    public List<Map> selectList(Map map) {
        return checkBidDao.selectList(map);
    }

    /**
     * 获取用户信息
     *
     * @param map
     * @return
     */
    @Override
    public List<Map> selectUserReal(Map map) {
        return checkBidDao.selectUserReal(map);
    }

    /**
     * 账户信息查询
     *
     * @param map
     * @return
     */
    @Override
    public List<Map> selectAnccout(Map map) {
        return checkBidDao.selectAccount(map);
    }

    /**
     * 确定通过审核的:
     *  1.更改原表状态
     *  2.审核人信息插入审核意见表
     * @param map
     * @return
     */
    @Override
    public int updateState(Map map, HttpSession httpSession) {
        /**
         * map中：
             * EMPID:审核人员id
             * ID:标的id
             * USERID:贷款人id
         * BIDSTATUS：审核结果
         * DATES：申请日期
         * ADVICE：审核意见
         */

        Map empMap = (Map)httpSession.getAttribute("emp");//拿到的是map集合
        if (empMap.size()>0){
            Integer id = Integer.valueOf(empMap.get("ID")+"");//拿到审核人员的id
            map.put("EMPID",id);//将审核人员id放到map中
            int i = bidAudit.insertBid(map);
            int j = checkBidDao.updateState(map);
            if (i==j){
                return 1;
            }
            return 0;
        }
        return 0;
    }

    /**
     * 添加集合方法
     * @return
     */
    @Override
    public Map getSum() {
        Map map = new HashMap();
        Double ljtzje = checkBidDao.selectOne();
        Double yhbx = checkBidDao.selectTwo();
        Double ye = checkBidDao.selectYe();
        Double zcrs = checkBidDao.selectZcrs();
        map.put("ljtzje",ljtzje);//累计投资金额
        map.put("yhbx",yhbx);
        map.put("ye",ye);
        map.put("zcrs",zcrs);
        return map;
    }
}

