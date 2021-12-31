package cn.chendahai.service;

import cn.chendahai.entity.Sport;
import java.util.List;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/4/24 0024
 */
public interface SportService {

    List<Sport> queryList();

    int updateAvatar(Integer id, String avatar);

    int updateDescription(Integer id, String description);

}
