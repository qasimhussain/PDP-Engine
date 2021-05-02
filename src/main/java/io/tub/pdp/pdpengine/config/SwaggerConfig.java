package io.tub.pdp.pdpengine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

     @Bean
    public Docket api(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .directModelSubstitute(LocalDate.class, String.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage( "io.tub.pdp.pdpengine" ))
                .paths(regex("/.*"))
                .build()
                .apiInfo(getApiInfo());

    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Patient Data Management Engine API",
                "API(s) for Patient Data Management Operations",
                "1.0",
                "",
                 new Contact("","",""),
                "",
                "",
                Collections.emptyList()
        );
    }

}
