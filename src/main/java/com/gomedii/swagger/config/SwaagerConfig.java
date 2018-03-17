package com.gomedii.swagger.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaagerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gomedii.swagger"))
                .paths(regex("/employee.*"))
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "employee api",
                "employee api for office",
                "2.0",
                "Terms of service",
                new Contact("arya", "https://www.gomedii.com", "aryasingh.ec@gmail.com.com"),
                "gomedii License Version 2.0",
                "https://www.gomedii.com/LICENSE-2.0");
        return apiInfo;
    }
}
