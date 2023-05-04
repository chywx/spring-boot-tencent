package cn.chendahai.controller;

import cn.chendahai.dao.SportDao;
import cn.chendahai.dao.WordPressDao;
import cn.chendahai.vo.JsonResult;
import cn.chendahai.vo.JsonResultFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author chenhaiyang
 * @Data 2023/5/4 15:46
 */
@Api(tags = "wordpress")
@RestController
@RequestMapping("/wordpress")
public class WordPressController {

    @Autowired
    WordPressDao wordPressDao;

    @ApiOperation("根据userId获取用户信息")
    @GetMapping("/user/getById")
    public JsonResult getById(@RequestParam Integer id) {
        Object object = wordPressDao.getById(id);
        return JsonResultFactory.success(object);
    }

}
