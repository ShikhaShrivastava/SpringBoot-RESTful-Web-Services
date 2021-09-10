package com.techment.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	    
	    public Docket myApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select().apis(RequestHandlerSelectors.basePackage("com.techment"))
	                .build().apiInfo(metaData());

	    }
	    
	    private ApiInfo metaData() {
	        ApiInfo apiInfo = new ApiInfo("my customer controller", "this api provides details of customers", "1.5v", "www.myblog.html", "SHIKHA", "apache", "http:hello.com");
	        return apiInfo;
	}
}
