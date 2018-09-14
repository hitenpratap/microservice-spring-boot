package com.fintechlabs.employeeservice.service;

import com.fintechlabs.employeeservice.client.EmployeeServiceClient;
import com.fintechlabs.employeeservice.commandObject.EmployeeCO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private EmployeeServiceClient employeeServiceClient;

    public Integer count(String emailAddress) {
        Integer count = 0;
        return count;
    }

    public void save(EmployeeCO employeeCO) {
        employeeServiceClient.save(employeeCO);
    }

}
