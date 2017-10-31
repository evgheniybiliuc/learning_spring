package home.learning.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * home.learning.spring.aspect
 * Created by vorsicht on 31/10/17.
 */
@Aspect
public class EmployeeAroundAspect {

    @Around("execution(* home.learning.spring.model.Employee.getName())")
    public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("Before invoking getName() method");
        Object value = null;

        try {
            value = proceedingJoinPoint.proceed();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("After invoking getName() .Return value is " + value);
        return value;
    }

}
