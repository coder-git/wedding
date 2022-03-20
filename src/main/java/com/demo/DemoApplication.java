package com.demo;

//import com.demo.common.filter.JwtAuthenticationTokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public FilterRegistrationBean registration(JwtAuthenticationTokenFilter filter) {
//		FilterRegistrationBean registration = new FilterRegistrationBean(filter);
//		registration.setEnabled(false);
//		return registration;
//	}
}
