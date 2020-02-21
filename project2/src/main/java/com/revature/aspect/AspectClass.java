package com.revature.aspect;

import org.springframework.stereotype.Component;

import com.revature.driver.Log4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author TeamLeo
 * The AspectClass is responsible for dealing with cross cutting concerns.
 * Primarily when implementing the logger, the aspect class uses Advice 
 * methods in order to identify point cuts and implement the logger when 
 * after a dao method has ran.
 */
@Component
@Aspect
public class AspectClass {
	
	/**
	 * Runs the logger every time the findAll() method
	 * has been executed.
	 * @param jp
	 */
	@After("execution(* findAll(..))")
	public void adviceMethodAfterFindAll(JoinPoint jp) {
		Log4j.log.info("findAll method in the Dao has ran.");
	}
	
	/**
	 * Runs the logger every time the findById() method
	 * has been executed.
	 * @param jp
	 */
	@After("execution(* findById(..))")
	public void adviceMethodAfterFindById(JoinPoint jp) {
		Log4j.log.info("findById method in the Dao has ran.");
	}
	
	/**
	 * Runs the logger every time the Update() method
	 * has been executed.
	 * @param jp
	 */
	@After("execution(* update(..))")
	public void adviceMethodAfterUpdate(JoinPoint jp) {
		Log4j.log.info("update method in the Dao has ran.");
	}
	
	/**
	 * Runs the logger every time the Insert() method
	 * has been executed.
	 * @param jp
	 */
	@After("execution(* insert(..))")
	public void adviceMethodAfterInsert(JoinPoint jp) {
		Log4j.log.info("insert method in the Dao has ran.");
	}
	
	/**
	 * Runs the logger every time the Delete() method
	 * has been executed.
	 * @param jp
	 */
	@After("execution(* delete(..))")
	public void adviceMethodAfterDelete(JoinPoint jp) {
		Log4j.log.info("delete method in the Dao has ran.");
	}
	
	/**
	 * Runs the logger every time the findByName() method
	 * has been executed.
	 * @param jp
	 */
	@After("execution(* findByName(..))")
	public void adviceMethodAfterFindByName(JoinPoint jp) {
		Log4j.log.info("findByName method in the Dao has ran.");
	}

}
