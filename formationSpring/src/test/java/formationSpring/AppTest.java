package formationSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	public static void main(String[] args) {
		Musicien musicien=null;
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("/application-context.xml");
		musicien=(Musicien)ctx.getBean("guitariste1");
		//musicien=ctx.getBean(Musicien.class);
		musicien=ctx.getBean("guitariste1", Musicien.class);
		musicien.jouer();
		musicien.changerInstrument(ctx.getBean("guitare",Instrument.class));
		musicien.jouer();
		ctx.close();
	}
}
