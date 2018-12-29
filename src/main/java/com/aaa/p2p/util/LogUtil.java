package com.aaa.p2p.util;

import com.aaa.p2p.controller.PowerController;
import com.aaa.p2p.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:LogUtil
 * discription:通知类（切面的实现类）
 * author:luRuiHua
 * createTime:2018-11-23 18:02
 */
//不属于三层架构
@Component//交给spring管理
@Aspect
public class LogUtil {


    //切入点配置//切入点表达式
    @Pointcut(value = "execution(* selectEmp(String))")
    public void pointCutOne() {};

    //切入点配置//切入点表达式
    @Pointcut(value = "execution(* com.aaa.p2p.service.*.*(..))")
    public void pointCutTwo() {};

    /**
     * 异常通知
     * 异常通知注解多了一个throwing = "exception"属性，值和参数列表中的值必须一样
     * 模拟时需要在service制造异常
     */
    @AfterThrowing(value = "pointCutTwo()",throwing = "exception")//切入点指向切入点表达式
    public void afterThrowingSavelog(JoinPoint joinPoint,Exception exception) {
        //获取目标对象
        String name = joinPoint.getTarget().getClass().getName();
        System.out.println("再调用"+name+"的"+"调用：" + joinPoint.getSignature().getName() + "方法之前，打印。。。方法时出现了"+exception.getClass().getName()+"异常，异常描述为："+exception.getMessage());
    }
    @Autowired
    private HttpSession httpSession;
    /**
     * 最终通知
     */
    /*@After(value = "pointCutOne()")//切入点指向切入点表达式
    public void afterSavelog(JoinPoint joinPoint) {
        String userName = httpSession.getAttribute("userName")+"";
        System.out.println("userName:"+userName);

        //获取目标对象
        String name = joinPoint.getTarget().getClass().getName();
        System.out.println("再调用"+name+"的"+"调用：" + joinPoint.getSignature().getName() + "方法之后，无论有没有异常都会打印。。。");
    }*/
    @Autowired
    private LogService logService;
    /**
     * 后置通知
     */
    @AfterReturning(value = "pointCutOne()")//切入点指向切入点表达式
    public void afterReturningSavelog(JoinPoint joinPoint) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        String userName = httpSession.getAttribute("userName")+"";
        String ip = httpSession.getAttribute("ip")+"";
        Map map = new HashMap();
        map.put("userName",userName);
        map.put("ip",ip);
        List<Map> maps = logService.selectLogin(map);
        if (maps.size()==0){
            logService.insertLogin(map);
        }






        /* //获取目标对象
        String name = joinPoint.getTarget().getClass().getName();
        System.out.println("再调用"+name+"的"+"调用：" + joinPoint.getSignature().getName() + "方法之前，打印。。。"); */
     }




}

