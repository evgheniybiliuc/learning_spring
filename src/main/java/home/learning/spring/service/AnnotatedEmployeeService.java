package home.learning.spring.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AnnotatedEmployeeService {
    @PostConstruct
    public void init(){
        System.out.println("AnnotationEmployeeService init() called");
    }

    public AnnotatedEmployeeService(){
        System.out.println("AnnotationEmployeeService constructor called");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("AnnotationEmployeeService destroy() called");
    }
}
