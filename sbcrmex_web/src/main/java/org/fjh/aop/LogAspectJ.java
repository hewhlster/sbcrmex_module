package org.fjh.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.fjh.authentication.JackUserDetails;
import org.fjh.entity.OptLog;
import org.fjh.service.IOptlogService;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

/**
 * @Classname LogAspectJ
 * @Description TODO
 * @Date 2020/5/29 10:28
 * @Created by 樊建华
 */
@Component
@Aspect
public class LogAspectJ {

    @Autowired
    IOptlogService optlogService;

    @Around(value = "execution(* org.fjh.action.*.*(..))"   )
    public Object around(ProceedingJoinPoint jp) {
        Object result=null;
        MethodSignature signature= (MethodSignature) jp.getSignature();

        //得到拦截的方法全路径
/*        Method method= signature.getMethod();
        String className= method.g
        String methodName = method.getName();*/
        String url = jp.getTarget().getClass()+"."+jp.getSignature().getName();
        url =url.replaceAll("class ","");

        //获取拦截方法的参数
        Object args[]=jp.getArgs();
        String datas=null;
        if(args!=null && args.length>0 ){
            datas= JSONObject.toJSONString(args[0]);
        }
        //获得调用者的IP
        String IP=null;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        IP= request.getRemoteAddr()+":"+request.getRemotePort();

        try {
                result = jp.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            } finally {

            OptLog optLog = new OptLog();

            //从SpringSecurity中取得以认证有用户
                    Object isAuthenticaiton=getContext().getAuthentication() .getPrincipal();
                    if ( !isAuthenticaiton.equals("anonymousUser")) {
                        JackUserDetails jackUserDetails = (JackUserDetails) isAuthenticaiton;
                        optLog.setUser(jackUserDetails.getUsername());
                    } else
                        optLog.setUser("anonymousUser");
                    optLog.setIp(IP);
                    optLog.setUrl(url);
                    optLog.setDatas(datas);
                    optLog.setRet(result.toString());

                    optlogService.insert(optLog);
            }

        return result;
    }
}
