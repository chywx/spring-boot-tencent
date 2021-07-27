package cn.chendahai.service.impl;

import cn.chendahai.dao.MiaoShaGoodsDao;
import cn.chendahai.entity.MiaoShaGoods;
import cn.chendahai.service.MiaoShaGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chy
 * @date 2021年07月27日 上午 11:09
 */
@Service
public class MiaoShaGoodsServiceImpl implements MiaoShaGoodsService {

    @Autowired
    MiaoShaGoodsDao miaoShaGoodsDao;

    @Override
    public MiaoShaGoods getById(Integer id) {
        return miaoShaGoodsDao.getById(id);
    }
}
