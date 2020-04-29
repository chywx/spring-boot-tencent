package cn.chendahai.dao;

import cn.chendahai.entity.Region;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/4/25 0025
 */
@Mapper
@Component
public interface RegionsDao {


    @Select("SELECT * FROM region where parent_id = #{pid}")
    List<Region> queryList(@Param("pid") Integer pid);
}
