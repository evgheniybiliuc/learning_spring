package home.learning.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * home.learning.spring.aspect
 * Created by vorsicht on 31/10/17.
 */
@Aspect
public class EmployeeAnnotationAspect {
    @Before("@annotation(home.learning.spring.Loggable)")
    public void beforeAnnotationAdvice(JoinPoint joinPoint) {
        System.out.println("Executing beforeAnnotationAdvice for method:" + joinPoint.toString());
    }

}
