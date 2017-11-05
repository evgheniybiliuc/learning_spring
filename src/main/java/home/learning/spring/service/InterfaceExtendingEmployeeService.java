package home.learning.spring.service;

import home.learning.spring.bean.Employee;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class InterfaceExtendingEmployeeService implements InitializingBean, DisposableBean {

    private Employee employee;

    public InterfaceExtendingEmployeeService() {
        System.out.println("EmployeeService no-args constructor called.");
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("EmployeeService afterPropertiesSet() initializing employee to dummy value");
        if (employee.getName() == null)
            employee.setName("John travolta");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("EmployeeService destroy()");
    }
}
