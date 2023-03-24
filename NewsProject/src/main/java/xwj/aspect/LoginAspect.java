package xwj.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;


@Aspect
@Slf4j
@Component
public class LoginAspect {
    static {
        System.out.println(LoginAspect.class.getName()+"被加载");
    }
    @Pointcut("execution(* xwj.controller.TestController.Test())")
    public void test() {

    }

//    public static final Logger log = LoggerFactory.getLogger(LoginAspect.class);

//    @Around("execution(* xwj.controller.user.UserController.login(..))")
    @After("test()")
    public void logBefore(JoinPoint joinPoint) throws Throwable {
        log.warn("测试日志：" + new Date().toString());
//        System.out.println("登录日志："+new Date().toString());
    }
}
