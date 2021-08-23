package formationSpring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import formationSpring.Guitare;
import formationSpring.Guitariste;
import formationSpring.Instrument;
import formationSpring.Musicien;

@Configuration
@ComponentScan({"formationSpring"})
public class AppConfig {

//	@Bean("guitare")
//	public Instrument guitare() {
//		return new Guitare();
//	}
//
//	@Bean
//	public Musicien guitariste(Instrument instrument) {
//		Guitariste guitariste = new Guitariste();
//		guitariste.setInstrument(instrument);
//		return guitariste;
//	}
}
