package com.oefa.tdrcreation.service.impl;


import com.oefa.tdrcreation.model.Employee;
import com.oefa.tdrcreation.repository.EmployeeRepository;
import com.oefa.tdrcreation.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeByEmail(String email) {
        log.info("Fetching an employee by email: {}", email);
        return employeeRepository.findEmployeeByEmail(email);
    }

    @Override
    public Employee create(Employee employee) {
        log.info("Saving new employee: {}", employee.getFirstName());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> listAllEmployee() {
        log.info("Fetching all employees");
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(String id) {
        log.info("Fetching an employee by id: {}", id);
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        log.info("Updating employee: {}", employee.getFirstName());
        Employee emp = employeeRepository.findById(employee.getId()).orElse(null);
        if(emp == null){
            log.info("Employee not found");
            return emp;
        }
        return employeeRepository.save(emp);
    }
}
