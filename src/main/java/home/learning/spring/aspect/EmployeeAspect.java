package home.learning.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * home.learning.spring.aspect
 * Created by vorsicht on 31/10/17.
 */
@Aspect
public class EmployeeAspect {

    @Before("execution(public String getName())")
    public void getNameAdvice() {
        System.out.println("Executing advice on getName()");
    }

    @Before("execution(* home.learning.spring.service.*.get*())")
    public void getAllAdvice() {
        System.out.println("Service method getter called");
    }
}
