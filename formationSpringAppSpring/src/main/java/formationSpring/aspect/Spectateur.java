package formationSpring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import formationSpring.Musicien;
import formationSpring.Pianiste;

@Component
@Aspect
public class Spectateur {

	@Autowired
	@Qualifier("guitariste")
	private Musicien guitariste;

	boolean first = true;

	@Pointcut("execution(* *.jouer())")
	public void jouer() {

	}

	private void installationPublic() {
		System.out.println("le public s'installe");
	}

	@AfterReturning(pointcut = "jouer()")
	public void applaudir() {
		System.out.println("le public applaudie");
	}

	@AfterThrowing(pointcut = "jouer()")
	public void siffler() {
		System.out.println("le public siffle");
	}

	@Before("jouer()")
	public void before() {
		if (first) {
			installationPublic();
			first = false;
		}
	}

	@Around("jouer()")
	public void around(ProceedingJoinPoint pjp)  {
		try {
			pjp.proceed();
		} catch (Throwable e) {
			
		}
		if (pjp.getTarget() instanceof Pianiste) {
			System.out.println("suivant");
			guitariste.jouer();
		}

	}

}
