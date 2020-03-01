package com.hzm.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : hzm
 * @date : 2020-02-29 23:25
 */
@Aspect
@Component
public class PrintAspect {
    @Pointcut("execution(* com..*.*(..))")
    private void printDateTime(){}
    @Before("printDateTime()")
    public void printDateTimeBefore(){
        System.out.println("-------"+new Date());
    }
}
