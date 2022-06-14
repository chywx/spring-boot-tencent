package cn.chendahai.controller;

import cn.chendahai.entity.Sport;
import cn.chendahai.service.SportService;
import cn.chendahai.vo.JsonResult;
import cn.chendahai.vo.JsonResultFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/4/24 0024
 */
@RestController
@RequestMapping("/bet")
@Api(tags = "体彩")
public class SportController {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
    }

    @Autowired
    private SportService sportService;

    @GetMapping("/sport")
    @ApiOperation("获取运动列表")
    public JsonResult jsonResult() {
        List<Sport> sportList = sportService.queryList();
        return JsonResultFactory.success(sportList);
    }

}
