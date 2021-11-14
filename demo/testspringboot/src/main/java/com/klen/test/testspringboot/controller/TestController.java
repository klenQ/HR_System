package com.klen.test.testspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/14
 */
@Controller
public class TestController {

    @RequestMapping("test")
    @ResponseBody
    public void test(){

        System.out.println("Hello World");
    }
}
