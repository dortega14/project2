package com.revature.aspect;

import org.springframework.stereotype.Component;

import com.revature.driver.Log4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Component
@Aspect
public class AspectClass {
	
	@After("execution(* findAll(..))")
	public void adviceMethodAfter(JoinPoint jp) {
		Log4j.log.info("findAll method in the Dao has ran.");
	}

}
