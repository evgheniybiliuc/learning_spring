package home.learning.spring.service;

import home.learning.spring.bean.Employee;

public class XmlEmployeeService {
    private Employee employee;


    public XmlEmployeeService() {
        System.out.println("XmlEmployeeService  constructor called");
    }

    public void init() {
        System.out.println("XmlEmployeeService init() called");
        if (employee != null)
            employee.setName("John Travolta");
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void destroy() {
        System.out.println("XmlEmployeeService destroy() called");
    }
}
