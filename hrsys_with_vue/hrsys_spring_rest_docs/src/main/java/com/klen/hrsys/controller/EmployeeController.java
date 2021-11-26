package com.klen.hrsys.controller;

import com.klen.hrsys.entity.Department;
import com.klen.hrsys.entity.Employee;
import com.klen.hrsys.service.DepartmentService;
import com.klen.hrsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("emp")
public class EmployeeController {

    @Autowired
    EmployeeService empService;
    @Autowired
    DepartmentService depService;


    @GetMapping
    public List<Employee> search(@RequestBody(required = false) Employee condition) {
        System.out.println(condition);
        return empService.search(condition);
    }

    @GetMapping("/{id}")
    public Employee search(@PathVariable Integer id) {
        return empService.searchById(id);
    }

    @PostMapping
    public boolean add(@RequestBody Employee emp) {
        return empService.add(emp);
    }

    @PutMapping
    public boolean update(@RequestBody Employee emp) {
        return empService.update(emp);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return empService.delete(id);
    }
}
