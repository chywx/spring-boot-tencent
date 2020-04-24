package cn.chendahai.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Sport implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String avatar;
    /**
     * 在betradar的编号
     */
    private String betradarId;
    private Date cts;

    private String description;
    private Date uts;
    /**
     * 0：无效 1:有效
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer seq;

}
