package com.lsz.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @ClassName ParamValidExceptionAspect
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/12/27 下午11:18
 * @Version 1.0.0
 **/
@Aspect
@Component
public class ParamValidExceptionAspect {

    @AfterThrowing(pointcut = "execution(* com.lsz..*.*(..))", throwing = "exception")
    public void handleParamValidException(JoinPoint joinPoint, ConstraintViolationException exception) {
        String message = exception.getConstraintViolations().stream()
                .map(constraintViolation -> constraintViolation.getPropertyPath() + ":" + constraintViolation.getMessage())
                .collect(Collectors.joining(","));
        System.out.println(joinPoint + ",message1 = " + message);
//        throw new RuntimeException(message);
    }

}
