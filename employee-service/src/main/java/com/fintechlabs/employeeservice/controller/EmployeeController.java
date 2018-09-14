package com.fintechlabs.employeeservice.controller;

import com.fintechlabs.employeeservice.commandObject.EmployeeCO;
import com.fintechlabs.employeeservice.dto.ApiResponse;
import com.fintechlabs.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@Valid @RequestBody EmployeeCO employeeCO) {
        if (employeeService.count(employeeCO.getEmailAddress()) > 0) {
            return new ResponseEntity<Object>(new ApiResponse(Boolean.FALSE, "Email Address is already taken!"), HttpStatus.BAD_REQUEST);
        }
        employeeService.save(employeeCO);
        return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "Employee has been registered successfully!"));
    }

}
