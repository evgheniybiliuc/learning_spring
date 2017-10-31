package home.learning.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

/**
 * home.learning.spring.aspect
 * Created by vorsicht on 31/10/17.
 */
@Aspect
public class EmployeeAspectJoinPoint {

    @Before("execution(public void home.learning.spring.model..set*(*))")
    public void loggingAdvicePointCut(JoinPoint joinPoint) {
        System.out.println("Applying logging advice on method" + joinPoint.toString());
        System.out.println("Arguments passed =" + Arrays.toString(joinPoint.getArgs()));
    }

    @Before("args(name)")
    public void logStringArguments(String name) {
        System.out.println("Passed string argument: " + name);
    }
}
