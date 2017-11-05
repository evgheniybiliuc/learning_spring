package home.learning.spring.service;

import home.learning.spring.model.Employee;

public class EmployeeService {
    private Employee employee;


    //constructor is used for autowired by constructor
    public EmployeeService(Employee employee) {
        System.out.println("Autowired by constructor used.");
        this.employee = employee;
    }

    //default constructor to avoid BeanInstantiationException for autowire byName or byType.
    public EmployeeService() {
        System.out.println("Default constructor used.");
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
