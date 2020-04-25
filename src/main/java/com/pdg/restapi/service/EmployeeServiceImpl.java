package com.pdg.restapi.service;

import com.pdg.restapi.model.Employee;
import com.pdg.restapi.repository.EmployeeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees(String sortParam, String dir) {
        return (List<Employee>) repository.findAll(Sort.by(Sort.Direction.fromString(dir), sortParam));
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = repository.findById(id);
        return employeeOptional.orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee emp = repository.findById(id).orElse(null);
        emp.setAge(employee.getAge());
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setPosition(employee.getPosition());

        Employee updated = repository.save(emp);

        return updated;
    }

    public void delete(Long id) {
//        Employee emp = repository.findById(id).orElse(null);
//        repository.delete(emp);
        repository.deleteById(id);
    }
}
