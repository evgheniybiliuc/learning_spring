package home.learning.spring.main;

import home.learning.spring.service.EmployeeAutowiredByConstructorService;
import home.learning.spring.service.EmployeeAutowiredByTypeService;
import home.learning.spring.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");

        EmployeeService employeeServiceByName = context.getBean("employeeServiceByName", EmployeeService.class);
        System.out.println("Xml / Autowire byName / Name is :"+employeeServiceByName.getEmployee().getName());

        EmployeeService employeeServiceByType = context.getBean("employeeServiceByType",EmployeeService.class);
        System.out.println("Xml / Autowire byType / Name is :"+employeeServiceByType.getEmployee().getName());

        EmployeeService employeeServiceByConstrutor = context.getBean("employeeServiceConstructor",EmployeeService.class);
        System.out.println("Xml / Autowire byConstructor / Name is :"+employeeServiceByType.getEmployee().getName());

        //printing hashcode to confirm all the objects are of different type
        System.out.println(employeeServiceByName.hashCode()+"::"+employeeServiceByType.hashCode()+"::"+employeeServiceByConstrutor.hashCode());


        //Autowire by annotation

        EmployeeAutowiredByTypeService employeeAutowiredByTypeService =  context.getBean("employeeAutowiredByTypeService",EmployeeAutowiredByTypeService.class);
        System.out.println("Annotation / Autowire on field / Name is :"+employeeAutowiredByTypeService.getEmployee().getName());

        EmployeeAutowiredByConstructorService employeeAutowiredByConstructorService =  context.getBean("employeeAutowiredByConstructorService",EmployeeAutowiredByConstructorService.class);
        System.out.println("Annotation / Autowire on constructor / Name is :"+employeeAutowiredByConstructorService.getEmployee().getName());
    }
}
