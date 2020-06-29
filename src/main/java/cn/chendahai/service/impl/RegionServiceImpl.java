package cn.chendahai.service.impl;

import cn.chendahai.dao.RegionsDao;
import cn.chendahai.entity.Region;
import cn.chendahai.service.RegionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/4/25 0025
 */
@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionsDao regionsDao;

    @Override
    public List<Region> queryList(Integer pid) {
        return regionsDao.queryList(pid);
    }

    @Override
    public List<Region> getAll() {
        return regionsDao.getAll();
    }

    @Override
    public int updatePinYinById(Integer id, String py) {
        return regionsDao.updatePinYinById(id, py);
    }
}
