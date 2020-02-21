package com.revature.aspect;

import org.springframework.stereotype.Component;

import com.revature.driver.Log4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * 
 * @author TeamLeo
 * <br>
 * <br>
 * The AspectClass is responsible for dealing with cross cut concerns.
 * <br>
 * Primarily when implementing the logger, the aspect class uses Advice methods in order to identify point cuts and 
 * implement the logger when the c
 */
@Component
@Aspect
public class AspectClass {
	
	@After("execution(* findAll(..))")
	public void adviceMethodAfterFindAll(JoinPoint jp) {
		Log4j.log.info("findAll method in the Dao has ran.");
	}
	
	@After("execution(* findById(..))")
	public void adviceMethodAfterFindById(JoinPoint jp) {
		Log4j.log.info("findById method in the Dao has ran.");
	}
	
	@After("execution(* update(..))")
	public void adviceMethodAfterUpdate(JoinPoint jp) {
		Log4j.log.info("update method in the Dao has ran.");
	}
	
	@After("execution(* insert(..))")
	public void adviceMethodAfterInsert(JoinPoint jp) {
		Log4j.log.info("insert method in the Dao has ran.");
	}
	
	@After("execution(* delete(..))")
	public void adviceMethodAfterDelete(JoinPoint jp) {
		Log4j.log.info("delete method in the Dao has ran.");
	}
	
	@After("execution(* findByName(..))")
	public void adviceMethodAfterFindByName(JoinPoint jp) {
		Log4j.log.info("findByName method in the Dao has ran.");
	}

}
