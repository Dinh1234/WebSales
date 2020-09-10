package com.websales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.websales.common.tag.BaseTag;

@SpringBootApplication
public class WebSalesSpringApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(WebSalesSpringApplication.class, args);
	}

	@Bean(name = "baseTag")
	public BaseTag baseTag() {
		return new BaseTag();
	}
}