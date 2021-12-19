package com.klen.hrsys.controller;

import com.klen.hrsys.entity.Department;
import com.klen.hrsys.entity.Employee;
import com.klen.hrsys.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("dep")
public class DepartmentController {

    @Autowired
    DepartmentService depService;

    @GetMapping("{id}")
    public Department search(@PathVariable Integer id) {
        return depService.searchById(id);
    }
    @GetMapping
    public List<Department> search() {
        return depService.search();
    }

    @PostMapping
    public boolean add(@RequestBody Department dep) {
        return depService.add(dep);

    }


    @PutMapping
    public boolean update(@RequestBody Department dep) {
        return depService.update(dep);

    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id) {
        return depService.delete(id);
    }
}
