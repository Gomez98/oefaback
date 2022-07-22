package com.oefa.tdrcreation.service;

import com.oefa.tdrcreation.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee create(Employee employee);
    List<Employee> listAllEmployee();
    Employee getEmployeeById(String id);
    Employee updateEmployee(Employee employee);
    Employee getEmployeeByEmail(String email);

}
