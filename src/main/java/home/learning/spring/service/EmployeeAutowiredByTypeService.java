package home.learning.spring.service;

import home.learning.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeAutowiredByTypeService {
    //Autowired annotation on variable/setter method is equivalent to autowire="byType"
    @Autowired
    private Employee employee;


    public Employee getEmployee() {
        return employee;
    }

    @Autowired
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
