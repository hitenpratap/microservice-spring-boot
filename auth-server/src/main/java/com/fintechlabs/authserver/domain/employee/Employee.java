package com.fintechlabs.authserver.domain.employee;

import com.fintechlabs.authserver.commandObject.EmployeeCO;
import com.fintechlabs.authserver.domain.User;
import com.fintechlabs.authserver.util.BeanUtil;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.password.PasswordEncoder;

@Document(collection = "users")
@TypeAlias("employees")
public class Employee extends User {

    private String phoneNumber;
    private String firstName;
    private String lastName;

    public Employee(){}

    public Employee(EmployeeCO employeeCO){
        this.setFirstName(employeeCO.getFirstName());
        this.setLastName(employeeCO.getFirstName());
        this.setPhoneNumber(employeeCO.getPhoneNumber());
        this.setEmailAddress(employeeCO.getEmailAddress());
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
