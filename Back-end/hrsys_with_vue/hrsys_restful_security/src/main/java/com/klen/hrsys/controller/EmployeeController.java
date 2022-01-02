package com.klen.hrsys.controller;

import com.klen.hrsys.entity.Employee;
import com.klen.hrsys.service.DepartmentService;
import com.klen.hrsys.service.EmployeeService;

import com.klen.hrsys.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("emp")
public class EmployeeController {

    @Autowired
    EmployeeService empService;
    @Autowired
    DepartmentService depService;


    @GetMapping
    public ServerResponse<List<Employee>> search(@RequestBody(required = false) Employee condition, Integer page, Integer size) {
        System.out.println(condition);
        Page<Employee> emps = empService.search(condition, page, size);
        ServerResponse<List<Employee>> sr = new ServerResponse<>(emps.getTotalElements(),emps.toList());
        return sr;
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
