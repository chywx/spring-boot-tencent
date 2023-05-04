package cn.chendahai.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description
 * @Author chenhaiyang
 * @Data 2023/5/4 16:05
 */
@Mapper
@Component
public interface WordPressDao {

    @Select("select * from wordpress.wp_users where id = #{id}")
    Map<String, Object> getById(@Param("id") Integer id);

}
