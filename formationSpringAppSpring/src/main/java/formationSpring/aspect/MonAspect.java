package formationSpring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import formationSpring.Guitariste;

public class MonAspect {

	
	
	
	@Pointcut("execution(* formationSpring.Musicien.jouer())")
	public void pointcut() {
	}

	@Before("pointcut()")
	public void before(JoinPoint joinPoint) {
		if (joinPoint.getTarget() instanceof Guitariste) {
			System.out.println("c'est un guitariste qui va jouer");
		} else {
			System.out.println("c'est un pianiste qui va jouer");
		}
		System.out.println("methode before jouer");
	}

	@AfterReturning(pointcut = "pointcut()")
	public void afterReturning() {
		System.out.println("methode afterReturning");
	}

	@AfterThrowing(pointcut = "pointcut()")
	public void afterThrowing() {
		methode();
	}
	
	private void methode() {
		System.out.println("une methode");
	}

	@After("pointcut()")
	public void after() {
		System.out.println("methode after");
	}

	@Around("pointcut()")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("around");
		System.out.println("execution de la methode jouer");
		proceedingJoinPoint.proceed();
		System.out.println("fin du around");
	}
}
