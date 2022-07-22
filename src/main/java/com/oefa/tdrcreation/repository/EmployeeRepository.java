package com.oefa.tdrcreation.repository;

import com.oefa.tdrcreation.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,String> {

    //You can create custom queries here
    public Employee findEmployeeByEmail(String email);
}
