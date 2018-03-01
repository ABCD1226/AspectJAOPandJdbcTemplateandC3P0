package com.eec.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eec.service.StudentService;

public class Test01 {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		StudentService service=(StudentService) ac.getBean("studentService");
		service.add();
	}

}
