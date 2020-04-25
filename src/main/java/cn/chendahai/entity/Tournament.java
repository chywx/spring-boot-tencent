package cn.chendahai.entity;


import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Tournament implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String sportCategoryId;

    private String year;

    private String name;

    private String avatar;
    /**
     * 在betradar方编号
     */
    private String betradarId;
    private Date cts;
    private Date uts;

    /**
     * 1:热门赛事 0:非热门
     */
    private Long scheduledTime;
    private Long scheduledEndTime;

    private Integer status;

}
