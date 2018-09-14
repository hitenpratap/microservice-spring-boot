package com.fintechlabs.authserver.controller.employee;

import com.fintechlabs.authserver.commandObject.EmployeeCO;
import com.fintechlabs.authserver.domain.UserRole;
import com.fintechlabs.authserver.domain.employee.Employee;
import com.fintechlabs.authserver.dto.api.ApiResponse;
import com.fintechlabs.authserver.repository.EmployeeRepository;
import com.fintechlabs.authserver.repository.RoleRepository;
import com.fintechlabs.authserver.repository.UserRepository;
import com.fintechlabs.authserver.repository.UserRoleRepository;
import com.fintechlabs.authserver.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RoleRepository roleRepository;

    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@Valid @RequestBody EmployeeCO employeeCO) {
        Employee employee = new Employee(employeeCO);
        employee.setPassword(passwordEncoder.encode(employeeCO.getPassword()));
        employeeRepository.save(employee);
        userRoleRepository.save(new UserRole(employee, roleRepository.findByName(AppConstant.ROLE_EMPLOYEE).get()));
        return ResponseEntity.ok(new ApiResponse(Boolean.TRUE, "Employee has been registered successfully!"));
    }

}
