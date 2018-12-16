package com.aaa.p2p.service;

import com.aaa.p2p.dao.OnPowerDao;
import com.aaa.p2p.dao.PowerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * className:OnPowerServiceImpl
 * discription:
 * author:luRuiHua
 * createTime:2018-12-16 18:54
 */
@Service
public class OnPowerServiceImpl implements OnPowerService {
    @Autowired
    private OnPowerDao onPowerDao;
    @Autowired
    private PowerDao powerDao;
    /**
     * 授权
     * @param powerIds
     * @param roleId
     * @return
     */
    @Override
    public int onPower(List powerIds, Integer roleId) {//[4,11,12]
        //需求：如果本身自己就是父id那么插自己就好了，
        //     如果是子id，根据子id找到父id将父id也插进去。
        //根据自己的powerid查询父id
        int i = 0;
        onPowerDao.deleteOnPower(roleId);//删除权限

        //遍历出所有树id
        for (Object powerId : powerIds) {
            //然后查出所有的树id的父id的集合，返回一条数据
            List<Map> fids = powerDao.selectFid(Integer.valueOf(powerId+""));
            int pid = Integer.valueOf(fids.get(0).get("PARENTID")+"");//拿到父id
            if (pid == 0){//只有父id等于0的才能进判断
                //将树的id插入
               i = onPowerDao.onPower(Integer.valueOf(powerId+""),roleId);//插自己
            } else {//父id不等于0，插入自己的，和父亲的
                onPowerDao.onPower(Integer.valueOf(powerId+""),roleId);//插自己
                //判断如果这个表里面已经有树id就不插了,该角色下
                //通过角色id查父id
                List<Map> mapList = powerDao.getFid(roleId);
                List PIDS = new ArrayList();
                for (int k = 0; k < mapList.size(); k++) {//获取mapList集合中的powerid放到一个集合里
                    Integer pids = Integer.valueOf(mapList.get(k).get("POWERID")+"");
                    PIDS.add(pids);//放入
                }
                if(PIDS.indexOf(pid) == -1){
                    i = onPowerDao.onPower(pid,roleId);
                }
            }
        }
        return i;
    }
}
