	package com.gomedii.swagger.config;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	
	import springfox.documentation.builders.RequestHandlerSelectors;
	import springfox.documentation.service.ApiInfo;
	import springfox.documentation.service.Contact;
	import springfox.documentation.spi.DocumentationType;
	import springfox.documentation.spring.web.plugins.Docket;
	import springfox.documentation.swagger2.annotations.EnableSwagger2;
	
	@Configuration
	@EnableSwagger2
	
	public class SwaagerConfig {
	    @Bean
	    public Docket employee() {
	        return new Docket(DocumentationType.SWAGGER_2)
	        		//.groupName("a1")
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .build()
	                .apiInfo(metaData());
	                //.apiInfo(metaData1());
	    }
	    

	    private ApiInfo metaData() {
	    	
	        ApiInfo apiInfo = new ApiInfo(
	                "employee api",
	                "employee api for office",
	                "2.0",
	                "Terms of service",
	                new Contact("arya", "https://www.gomedii.com", "aryasingh.ec@gmail.com.com"),
	                "gomedii.com License Version 2.0",
	                "https://www.gomedii.com/LICENSE-2.0");
	        return apiInfo;
	    }
	    
	   /* private ApiInfo metaData1() {
	        ApiInfo apiInfo = new ApiInfo(
	                "department api",
	                "department api for office",
	                "2.0",
	                "Terms of service",
	                new Contact("arya", "https://www.gomedii.com", "aryasingh.ec@gmail.com.com"),
	                "gomedii.com License Version 2.0",
	                "https://www.gomedii.com/LICENSE-2.0");
	        return apiInfo;
	    }*/
	}
	
	
	
