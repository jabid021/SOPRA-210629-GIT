package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import voyage.Principal;
import voyage.config.AppConfig;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(Principal.class).run(args);
		ctx.close();
	}

}
