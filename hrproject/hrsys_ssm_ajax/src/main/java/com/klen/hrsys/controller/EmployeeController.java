package com.klen.hrsys.controller;

import com.klen.hrsys.entity.Department;
import com.klen.hrsys.entity.Employee;
import com.klen.hrsys.service.DepartmentService;
import com.klen.hrsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description:
 * @Author: Jianyu Qiu (Kalen)
 * @CreateTime: 2021/11/16
 */
@RequestMapping("emp")
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @RequestMapping("search")
    public ModelAndView search(Employee condition){
        ModelAndView mv = new ModelAndView("emp/show");

        List<Employee> list = employeeService.search(condition);
        List<Department> depList = departmentService.search();
        mv.addObject("list",list);
        mv.addObject("depList",depList);
        mv.addObject("c",condition);
        return mv;
    }
    //search by condition ajax
    @RequestMapping("searchByCondition")
    @ResponseBody
    public List<Employee> searchByCondition(Employee condition){
        System.out.println(condition);
        return employeeService.search(condition);
    }

    @RequestMapping("showAdd")
    public ModelAndView showAdd() {
        ModelAndView mv = new ModelAndView("emp/add");
        List<Department> depList = departmentService.search();
        mv.addObject("depList", depList);
        return mv;
    }

    @RequestMapping("add")
    public String add(Employee emp) {
        boolean flag = employeeService.add(emp);
        return "redirect:search";
    }
    @RequestMapping("showUpdate")
    public ModelAndView showUpdate(Integer id) {
        Employee emp = employeeService.searchById(id);
        List<Department> depList = departmentService.search();
        ModelAndView mv = new ModelAndView("emp/update");
        mv.addObject("emp", emp);
        mv.addObject("depList", depList);
        return mv;
    }

    @RequestMapping("update")
    public String update(Employee emp) {
        boolean flag = employeeService.update(emp);
        return "redirect:search";
    }

    @RequestMapping("delete")
    public String delete(Integer id) {
        boolean flag = employeeService.delete(id);
        return "redirect:search";
    }


}
