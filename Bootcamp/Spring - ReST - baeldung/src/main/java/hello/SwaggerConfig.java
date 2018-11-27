package hello;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {   /* this was the non restricted documentation 
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
    /*6.1 this only shows controllers from a particular package, this is done with the ant() predicate 
    @Bean
    public Docket api() {                
        return new Docket(DocumentationType.SWAGGER_2)          
        .select()                                       
        .apis(RequestHandlerSelectors.basePackage("org.baeldung.web.controller"))
        .paths(PathSelectors.ant("/foos/*"))                     
        .build();
    }*/

    /*6.2and this one is used to customize the default information provided by swagger*/
    @Bean
    public Docket api() {                
        return new Docket(DocumentationType.SWAGGER_2)          
        .select()
        .apis(RequestHandlerSelectors.basePackage("org.baeldung.web.controller"))
        .paths(PathSelectors.ant("/foos/*"))
        .build()
        .apiInfo(apiInfo());
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
        "My REST API", 
        "Some custom description of API.", 
        "API TOS", 
        "Terms of service", 
        new Contact("John Doe", "www.example.com", "myeaddress@company.com"), 
        "License of API", "API license URL",Collections.emptyList());
    }
    
}