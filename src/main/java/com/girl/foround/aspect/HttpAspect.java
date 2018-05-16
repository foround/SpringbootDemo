package com.girl.foround.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 郑旭 790573267@qq.com
 * @version 0.0.1 创建时间: 2018/5/16 0016 21:49
 * <p>
 * 类说明：
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.girl.foround.controller.GirlController.*(..))")
    public void log(){

    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = attributes.getRequest();
        logger.info("url is {}",httpServletRequest.getRequestURL());
        logger.info("Method is {}",httpServletRequest.getMethod());
        logger.info("ip is {}",httpServletRequest.getRemoteAddr());
        logger.info("class_method is {}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("args is {}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
        logger.info("返回后");
    }
    @AfterReturning(pointcut = "log()",returning = "object")
    public void doAfterReturn(Object object){
        logger.info(object.toString());
    }
}
