package cn.chendahai.entity;

import lombok.Data;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/4/25 0025
 */
@Data
public class Region {

    private Integer id;

    private Integer parentId;

    private String regionName;

    private Integer code;

    private Integer regionType;

    private Boolean last;

}
