package com.oefa.tdrcreation.controller;

import com.oefa.tdrcreation.model.Employee;
import com.oefa.tdrcreation.model.Response;
import com.oefa.tdrcreation.service.impl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @GetMapping("/list")
    public ResponseEntity<Response> getAllEmployees(){
        List<Employee> list = employeeService.listAllEmployee();
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("employees", list == null ? "": list))
                        .message( list.isEmpty() ? "No employees registered" : "Employees retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/login")
    public ResponseEntity<Response> getEmployeeByEmail(@RequestBody String email){
        Employee emp = employeeService.getEmployeeByEmail(email);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("employee", emp == null ? "" : emp))
                        .message( emp == null ? "Employee not found" : "Employees retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getEmployeeById(@PathVariable("id") String id){
        Employee emp = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("employee", emp == null ? "" : emp))
                        .message(emp == null ? "Employee not found" : "Employee retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping ("/save")
    public ResponseEntity<Response> saveEmployee(@RequestBody @Valid Employee employee){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("employee", employeeService.create(employee)))
                        .message("Employee created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @PostMapping ("/update")
    public ResponseEntity<Response> updateEmployee(@RequestBody @Valid Employee employee){
        Employee emp = employeeService.updateEmployee(employee);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("employee", emp == null ? "": emp))
                        .message(emp == null ? "Employee not found" : "Employee updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
