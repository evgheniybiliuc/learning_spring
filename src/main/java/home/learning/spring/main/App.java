package home.learning.spring.main;

import home.learning.spring.service.AnnotatedEmployeeService;
import home.learning.spring.service.InterfaceExtendingEmployeeService;
import home.learning.spring.service.XmlEmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        InterfaceExtendingEmployeeService interfaceExtendingEmployeeService = context.getBean("employeeService", InterfaceExtendingEmployeeService.class);
        System.out.println("interfaceExtendingEmployeeService Employee name :" + interfaceExtendingEmployeeService.getEmployee().getName());

        XmlEmployeeService xmlEmployeeService = context.getBean("xmlEmployeeService", XmlEmployeeService.class);
        System.out.println("interfaceExtendingEmployeeService Employee name :" + xmlEmployeeService.getEmployee().getName());

        AnnotatedEmployeeService annotatedEmployeeService = context.getBean("annotatedEmployeeService", AnnotatedEmployeeService.class);
        //System.out.println("interfaceExtendingEmployeeService Employee name :" + annotatedEmployeeService.getEmployee().getName());
    }
}
