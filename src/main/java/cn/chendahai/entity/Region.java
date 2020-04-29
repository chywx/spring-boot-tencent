package cn.chendahai.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/4/25 0025
 */
@Data
@ApiModel("区域对象信息")
public class Region {

    @ApiModelProperty("id值")
    private Integer id;

    @ApiModelProperty("父id值")
    private Integer parentId;

    @ApiModelProperty("区域名称")
    private String regionName;

    @ApiModelProperty("行政区划编码")
    private Integer code;

    @ApiModelProperty("级别：1为province, 2为city, 3为district")
    private Integer regionType;

    @ApiModelProperty("是否为最后一级 0表示不是 1表示是")
    private Boolean last;

}
