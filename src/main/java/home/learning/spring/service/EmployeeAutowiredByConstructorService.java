package home.learning.spring.service;

import home.learning.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmployeeAutowiredByConstructorService {

    private Employee employee;

    //Autowired annotation on construct is equivalent to autowire="constructor"
    @Autowired(required = false)
    public EmployeeAutowiredByConstructorService(@Qualifier("employee") Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
