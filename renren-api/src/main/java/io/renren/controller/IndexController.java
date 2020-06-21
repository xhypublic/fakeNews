package io.renren.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
public class IndexController {
    @RequestMapping("/index")
    @ApiOperation("访问主页")
    public String index(){
        return "index";
    }
}
