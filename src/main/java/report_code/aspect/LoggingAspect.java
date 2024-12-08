package report_code.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* report_code.service.*.*(..))")
    public void logBefore() {
        System.out.println("Before method execution");
    }

    @After("execution(* report_code.service.*.*(..))")
    public void logAfter() {
        System.out.println("After method execution");
    }

    @AfterReturning("execution(* report_code.service.*.*(..))")
    public void logAfterReturning() {
        System.out.println("After returning from method");
    }

    @AfterThrowing("execution(* report_code.service.*.*(..))")
    public void logAfterThrowing() {
        System.out.println("After throwing exception");
    }

    @Around("execution(* report_code.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around method execution");
        Object result = joinPoint.proceed();
        System.out.println("Around method execution completed");
        return result;
    }
}
