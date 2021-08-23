package formationSpring.aspect;

public class DemoAspect {

	public void before() {
		System.out.println("methode before de DemoAspect");
	}

	public void afterReturning() {
		System.out.println("methode afterReturning de DemoAspect");
	}
}
