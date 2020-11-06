package com.springboot.ijam.app.constructora;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.build();
	}
	
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("API REST CONSTRUCTORA")
				.version("1.0")
				.license("Apache License Version 2.0")
				.contact(contact())
				.build();
	}
	
	private Contact contact() {
		return  new Contact("Isaac", "page_new", "i.aranda.maldonado@gmail.com");
	}
}
