package home.learning.spring.service;

import home.learning.spring.model.Employee;

/**
 * home.learning.spring.service
 * Created by vorsicht on 31/10/17.
 */
public class EmployeeService {
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
