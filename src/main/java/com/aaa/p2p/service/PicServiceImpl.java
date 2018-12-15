package com.aaa.p2p.service;

import com.aaa.p2p.dao.PicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:PicServiceImpl
 * discription:
 * author:luRuiHua
 * createTime:2018-12-12 17:05
 */
@Service
public class PicServiceImpl implements PicService {
    @Autowired
    private PicDao picDao;
    /**
     * 获取图片列表
     * @param map
     * @return
     */
    @Override
    public List<Map> getPicByLoc(Map map) {
        return picDao.getPicByLoc(map);
    }

    /**
     * 更改图片的url
     * @param url
     * @param loc
     * @return
     */
    @Override
    public int updateUrl(String url, String loc) {
        return picDao.updateUrl(url,loc);
    }
}
