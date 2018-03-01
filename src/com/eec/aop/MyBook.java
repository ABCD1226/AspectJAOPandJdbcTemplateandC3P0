package com.eec.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBook {
	// 前置增强
	@Before(value = "execution(* com.eec.aop.Book.*(..))")
	public void add() {
		System.out.println("到看书的时间了------------------");
	}

	// 后置增强
	@After(value = "execution(* com.eec.aop.Book.*(..))")
	public void stop() {
		System.out.println("看了好长时间的书了，该休息了-------");
	}

	// 环绕增强
	@Around(value = "execution(* com.eec.aop.Book.*(..))")
	public void around(ProceedingJoinPoint point) throws Throwable {
		// 前置增强
		System.out.println("王小姗，前置增强");

		// 调用被增强方法
		point.proceed();

		// 后置增强
		System.out.println("余竹霞，后置增强");
	}

	// 后置通知，当没有异常发生时，不会出现此通知
	@AfterThrowing(value = "execution(* com.eec.aop.Book.*(..))")
	public void afterThrowing() {
		System.out.println("异常了！！！！");
	}

}
