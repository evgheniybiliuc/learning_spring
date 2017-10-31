package home.learning.spring;

import home.learning.spring.model.Employee;
import home.learning.spring.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * home.learning.spring
 * Created by vorsicht on 31/10/17.
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        EmployeeService employeeService = context.getBean(EmployeeService.class);
        Employee employee = employeeService.getEmployee();

        System.out.println(employee.getName());
        employee.setName("John Travolta");
        employee.throwException();

        context.close();
    }
}
