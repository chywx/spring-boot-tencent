package cn.chendahai.dao;

import cn.chendahai.entity.MiaoShaGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author chy
 * @date 2021年07月27日 上午 11:05
 */
@Mapper
@Component
public interface MiaoShaGoodsDao {

    @Select("select * from miao_sha_goods where id = #{id}")
    MiaoShaGoods getById(@Param("id") Integer id);

}
