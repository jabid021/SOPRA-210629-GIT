package formationSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import formationSpring.config.AppConfig;

public class AppTest {
	public static void main(String[] args) {
		Musicien musicien = null;
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		musicien = ctx.getBean("guitariste", Musicien.class);
		musicien.jouer();

		ctx.close();
	}
}
