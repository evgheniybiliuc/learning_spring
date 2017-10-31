package home.learning.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * home.learning.spring.aspect
 * Created by vorsicht on 31/10/17.
 */
@Aspect
public class EmployeeAspectPointcut {

    @Before("getNamePointCut()")
    public void loggingAdvice() {
        System.out.println("Executing loggingAdvice on getName()");
    }

    @Before("getNamePointCut()")
    public void secondAdvice() {
        System.out.println("Executing secondAdvice on getName()");
    }

    @Pointcut("execution(public String getName())")
    public void getNamePointCut() {
    }

    @Before("allMethodsPointcut()")
    public void allServiceMethodAdvice() {
        System.out.println("Before executing service method");
    }

    @Pointcut("within(home.learning.spring.service.*)")
    public void allMethodsPointcut() {
    }
}
