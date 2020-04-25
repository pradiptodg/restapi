package com.pdg.restapi.service;

import com.pdg.restapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees(String sortParam, String dir);
    Employee getEmployeeById(Long id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    void delete(Long id);
}
