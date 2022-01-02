package com.klen.hrsys.controller;

import com.klen.hrsys.entity.Department;
import com.klen.hrsys.entity.Employee;
import com.klen.hrsys.service.DepartmentService;
import com.klen.hrsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("emp")
public class EmployeeController {

    @Autowired
    EmployeeService empService;
    @Autowired
    DepartmentService depService;

    @RequestMapping(value = "show")
    public String show() {
        return "emp/show";
    }

    @RequestMapping("showAdd")
    public String showAdd() {
        return "emp/add";
    }

    @RequestMapping("showUpdate")
    public ModelAndView showUpdate(Integer id) {
        ModelAndView mv = new ModelAndView("emp/update");
        mv.addObject("id", id);
        return mv;
    }


    @RequestMapping(value = "search")
    @ResponseBody
    public List<Employee> search(Employee condition) {
        System.out.println(condition);
        return empService.search(condition);
    }

    @RequestMapping(value = "searchById")
    @ResponseBody
    public Employee search(Integer id) {
        return empService.searchById(id);
    }

    @RequestMapping("add")
    @ResponseBody
    public boolean add(@RequestBody Employee emp) {
        return empService.add(emp);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public boolean update(@RequestBody Employee emp) {
        return empService.update(emp);
    }

    @RequestMapping("delete")
    public String delete(Integer id) {
        boolean flag = empService.delete(id);
        return "redirect:show";
    }
}
