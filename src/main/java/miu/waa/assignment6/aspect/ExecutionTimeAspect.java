package miu.waa.assignment6.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Pointcut("@annotation(miu.waa.assignment6.aspect.annotation.ExecutionTime)")
    public void executeTimeAnnotation() {
    }

    @Around("executeTimeAnnotation()")
    public Object calculateExecuteTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes time ms: " + (finish - start));
        return result;
    }

}
