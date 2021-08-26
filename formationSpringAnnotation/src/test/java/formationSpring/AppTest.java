package formationSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	public static void main(String[] args) {
		Musicien musicien=null;
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("/application-context.xml");
		musicien=(Musicien)ctx.getBean("guitariste");
		//musicien=ctx.getBean(Musicien.class);
		musicien=ctx.getBean("guitariste", Musicien.class);
		musicien.jouer();
		System.out.println(musicien.toString());
		ctx.close();
	}
}
