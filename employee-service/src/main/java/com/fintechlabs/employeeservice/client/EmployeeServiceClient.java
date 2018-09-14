package com.fintechlabs.employeeservice.client;

import com.fintechlabs.employeeservice.commandObject.EmployeeCO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "auth-service")
public interface EmployeeServiceClient {

    @RequestMapping(method = RequestMethod.POST, value = "/uaa/employees", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<?> save(@RequestBody EmployeeCO employeeCO);

}
