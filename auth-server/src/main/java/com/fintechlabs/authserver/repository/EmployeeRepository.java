package com.fintechlabs.authserver.repository;

import com.fintechlabs.authserver.domain.employee.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

    Integer countByEmailAddress(String emailAddress);

}
