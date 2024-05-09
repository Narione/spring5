package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// AOP 설정파일이라고 스프링에게 알려주는 애노테이션
@Aspect
@Component
public class StudentAspect {

    @Pointcut("execution(void org.example.aop.Student.doSomething())")
    public void studentTarget(){

    }

//    @Before("studentTarget()")
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.print(className+"가 ");
        System.out.println("현관문을 열고 집에 들어온다.");
    }

//    @After("studentTarget()")
    public void after(JoinPoint joinPoint) {
        System.out.println("잠을 잔다.");
        System.out.println("현관문을 닫고 집을 나온다.");
    }

    @Around("studentTarget()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        before(joinPoint);
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            if(e.getMessage().equals("불이야!")){
                System.out.println("119에 신고합니다.");
            }
        }
        after(joinPoint);
        return null;
    }

}
