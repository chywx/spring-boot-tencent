package cn.chendahai.dao;

import cn.chendahai.entity.Sport;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    @Update("update sport set avatar = #{avatar} where id = #{id}")
    int updateAvatar(@Param("id") Integer id, @Param("avatar") String avatar);

    @Update("update sport set description = #{description} where id = #{id}")
    int updateDescription(@Param("id") Integer id, @Param("description") String description);
}
