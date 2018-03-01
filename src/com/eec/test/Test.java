package com.eec.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eec.aop.Book;

public class Test {
	public static void main(String[] args) {
		//spring中基于AspectJ的注解AOP
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Book book=(Book) ac.getBean("book");
		book.seeBook();
	}
}
