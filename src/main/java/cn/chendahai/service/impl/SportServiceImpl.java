package cn.chendahai.service.impl;

import cn.chendahai.dao.SportDao;
import cn.chendahai.entity.Sport;
import cn.chendahai.service.SportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/4/24 0024
 */
@Service
public class SportServiceImpl implements SportService {

    @Autowired
    private SportDao sportDao;

    @Override
    public List<Sport> queryList() {
        return sportDao.queryList();
    }
}
