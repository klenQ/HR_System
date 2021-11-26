package com.klen.hrsys.controller;

import com.klen.hrsys.entity.Department;
import com.klen.hrsys.entity.Employee;
import com.klen.hrsys.service.DepartmentService;
import com.klen.hrsys.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("emp")
@Api(value="Employee Controller",tags = "员工接口")
public class EmployeeController {

    @Autowired
    EmployeeService empService;
    @Autowired
    DepartmentService depService;


    @ApiOperation(value="search all employee", notes = "查询所有员工")
    @GetMapping
    @ApiImplicitParam(dataType = "com.klen.hrsys.entity.Employee")
    public List<Employee> search(@RequestBody(required = false) Employee condition) {
        System.out.println(condition);
        return empService.search(condition);
    }

    @ApiOperation(value = "search employee by id", notes = "根据ID查询单个员工")
    @GetMapping("/{id}")
    public Employee search(@ApiParam(name="员工id",value="id",required=true) @PathVariable Integer id) {
        return empService.searchById(id);
    }

    @ApiOperation(value = "add employee", notes = "添加员工")
    @PostMapping
    @ApiImplicitParam(dataType = "com.klen.hrsys.entity.Employee")
    public boolean add(@RequestBody Employee emp) {
        return empService.add(emp);
    }

    @ApiOperation(value = "update employee", notes = "修改员工")
    @PutMapping
    @ApiImplicitParam(dataType = "com.klen.hrsys.entity.Employee")
    public boolean update(@RequestBody Employee emp) {
        return empService.update(emp);
    }

    @ApiOperation(value = "delete employee", notes = "删除员工")
    @DeleteMapping("/{id}")
    public boolean delete(@ApiParam(name="员工 id", value = "id", required = true) @PathVariable Integer id) {
        return empService.delete(id);
    }
}
