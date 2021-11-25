package com.klen.hrsys.controller;

import com.klen.hrsys.entity.Employee;
import com.klen.hrsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/18
 */
@Controller
public class TestController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("test")
    public ModelAndView test() {
        ModelAndView mv = new ModelAndView("test");
        mv.addObject("msg", "<h1>From Controller</h1>");
        Employee emp = employeeService.searchById(10001);
        mv.addObject("emp", emp);
        return mv;
    }
}
