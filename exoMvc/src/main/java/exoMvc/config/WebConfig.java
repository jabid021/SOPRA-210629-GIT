package exoMvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import eshop.config.AppConfig;

@Configuration
@EnableWebMvc
@ComponentScan({ "exoMvc.controller", "exoMvc.restcontroller" })
@Import(AppConfig.class)
public class WebConfig {

	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver uBVR = new UrlBasedViewResolver();
		uBVR.setPrefix("/WEB-INF/views/");
		uBVR.setSuffix(".jsp");
		uBVR.setViewClass(JstlView.class);
		return uBVR;
	}
}
