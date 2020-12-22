package cn.chendahai.dao;

import cn.chendahai.entity.Sport;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/4/24 0024
 */
@Mapper
@Component
public interface SportDao {

    /**
     * 运动列表
     */
    @Select("SELECT id,name,betradar_id betradarId,seq FROM `sport`")
    List<Sport> queryList();
}
