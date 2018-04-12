package com.core.controller;

import com.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author renyangze
 * @date 2018/3/26
 */
@Controller
@RequestMapping(value = "index")
public class IndexController extends BaseController{


    @RequestMapping
    private String index(){
        return "index.html";
    }

    @RequestMapping(value = "test")
    private String test(){
        return "test";
    }
}
