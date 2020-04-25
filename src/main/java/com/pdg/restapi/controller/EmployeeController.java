package com.pdg.restapi.controller;

import com.pdg.restapi.model.Employee;
import com.pdg.restapi.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Employee> getAllEmployees(
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortParam,
            @RequestParam(value = "dir", required = false, defaultValue = "asc") String dir) {
        return service.getAllEmployees(sortParam, dir);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PostMapping("/")
    public Employee createEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    @PutMapping("/")
    public Employee editEmployee(@RequestBody Employee employee) {
        return service.updateEmployee(employee.getId(), employee);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }
}
