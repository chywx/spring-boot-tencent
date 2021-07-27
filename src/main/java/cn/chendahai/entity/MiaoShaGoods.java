package cn.chendahai.entity;

import java.util.Date;
import lombok.Data;

/**
 * @author chy
 * @date 2021年07月27日 上午 11:02
 */
@Data
public class MiaoShaGoods {

    private Integer id;

    private String name;

    private Integer sum;

    private Integer version;

    private Date cts;

    private Date uts;

}
