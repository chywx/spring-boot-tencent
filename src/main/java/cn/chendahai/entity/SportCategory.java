package cn.chendahai.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class SportCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 所属的运动类别
     */
    private String sportId;
    private String name;
    private String avatar;
    /**
     * 在betradar方的编号
     */
    private String betradarId;
    private String description;
    private Integer status;

    private String countryCode;

    private Integer seq;

}
