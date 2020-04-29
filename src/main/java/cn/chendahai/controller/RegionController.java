package cn.chendahai.controller;

import cn.chendahai.entity.Region;
import cn.chendahai.service.RegionService;
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
 * @date 2020/4/25 0025
 */
@RestController
@RequestMapping("/region")
@Api(tags = "省市信息接口")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @ApiOperation("根据父id获取区域信息")
    @GetMapping("regionList")
    public JsonResult regionList(Integer pid) {
        if (pid == null) {
            pid = 0;
        }
        List<Region> regions = regionService.queryList(pid);
        return JsonResultFactory.success(regions);
    }

}
