package com.lttltm.fans.onesearch.config.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lttltm.fans.onesearch.model.User;
import com.lttltm.fans.onesearch.util.JsonUtil;

@Aspect
@Component
public class LogAspectMVC {

	private Logger logger = LoggerFactory.getLogger(LogAspectMVC.class);

	@Around("execution(* com.lttltm.fans.onesearch.controller.*.*(..))")
	public Object methodAspect(ProceedingJoinPoint point) throws Throwable{
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
	    HttpSession session = request.getSession();
	    String user = SecurityContextHolder.getContext().getAuthentication().getName();
	    //读取session中的用户    
//      User user = (User) session.getAttribute("CURRENT_USER");  
	    
        //请求的IP    
        String ip = request.getRemoteAddr();
        String params = "";    
        if (point.getArgs() != null && point.getArgs().length > 0) {    
            for ( int i = 0; i < point.getArgs().length; i++) {    
               params += point.getArgs()[i] + ";";    
           }    
        }    

		logger.info("Request user:" + user + ",session:" + session.getId() + ", ip:" + ip + ", method:" + point.getTarget().getClass() + "."
		 + point.getSignature().getName() + ", params：" + params);
		return point.proceed();
	}

}
