package com.gowaiterless.api.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class logginAspect {
	
	@Before("within(com.gowaiterless.api.service.*)")
	public void loggingAdvice(){
		System.out.println("loggingAdvice Get Called");
	}

}
