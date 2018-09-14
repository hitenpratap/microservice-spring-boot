package com.fintechlabs.authserver.util;

import com.fintechlabs.authserver.domain.Role;
import com.fintechlabs.authserver.domain.UserRole;
import com.fintechlabs.authserver.domain.employee.Employee;
import com.fintechlabs.authserver.repository.EmployeeRepository;
import com.fintechlabs.authserver.repository.RoleRepository;
import com.fintechlabs.authserver.repository.UserRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Bootstrap {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public void createRole() {
        List<String> roleList = Arrays.asList(AppConstant.ROLE_EMPLOYEE, AppConstant.ROLE_ADMIN);
        LOG.info("Inside createRole() of BootstrapService with roles    ===>>>  {}", roleList.toString());
        for (String roleName : roleList) {
            LOG.info("Count of Role with name  {}   =>  {}", roleName, roleRepository.countByName(roleName));
            if (roleRepository.countByName(roleName) == 0) {
                LOG.info("Creating Role with name   ====>>>>    {}", roleName);
                roleRepository.save(new Role(roleName));
            }
        }
    }

    public void createEmployee() {
        if (employeeRepository.countByEmailAddress("employee1@email.com") == 0) {
            Employee employee = new Employee();
            employee.setEmailAddress("employee1@email.com");
            employee.setPassword(passwordEncoder.encode("employee@#123"));
            employee.setFirstName("Test");
            employee.setLastName("Employee #1");
            employee.setPhoneNumber("1928374650");
            employeeRepository.save(employee);
            userRoleRepository.save(new UserRole(employee, roleRepository.findByName(AppConstant.ROLE_EMPLOYEE).get()));
        }
    }

}
