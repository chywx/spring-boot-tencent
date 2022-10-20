package cn.chendahai.service.impl;

import cn.chendahai.dao.SportDao;
import cn.chendahai.entity.Sport;
import cn.chendahai.service.SportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int updateAvatar(Integer id, String avatar) {
        return sportDao.updateAvatar(id, avatar);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int updateDescription(Integer id, String description) {
        int i = sportDao.updateDescription(id, description);
        int k = 1 / 0;
        return i;
    }
}
