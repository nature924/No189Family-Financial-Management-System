package com.example.cwgl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* description:TODO
* @author zhangsihai
* @date 2020/3/24 15:28
*/
@Controller
public class UtilController {

    @RequestMapping("/pages/{page}")
    public String toPage(@PathVariable String page) {
        return page.replace("_", "/");
    }

}
