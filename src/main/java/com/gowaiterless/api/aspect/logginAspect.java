package com.gowaiterless.api.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class logginAspect {
	
	@Pointcut("within(com.gowaiterless.api.service.*)")
	public void allServiceMethod(){}
	
	@Pointcut("execution(public * com.gowaiterless.api.service.*.get*(..))")
	public void allServiceGetters(){}

}
