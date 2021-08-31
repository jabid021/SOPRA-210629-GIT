package formationSpringMvc.config;

import org.apache.taglibs.standard.tlv.JstlBaseTLV;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("formationSpringMvc.controller")
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("han");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
	}

	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver uBVR = new UrlBasedViewResolver();
		uBVR.setViewClass(JstlView.class);
		uBVR.setPrefix("/WEB-INF/views/");
		uBVR.setSuffix(".jsp");
		return uBVR;
	}
}
