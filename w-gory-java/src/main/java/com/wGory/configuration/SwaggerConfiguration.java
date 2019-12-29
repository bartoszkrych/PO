package com.wGory.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.temporal.Temporal;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket controllersApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(
                        RequestHandlerSelectors.basePackage(
                                "com.wGory.controller.controller"))
                .build()
                .apiInfo(apiInfo())
                .directModelSubstitute(Temporal.class, String.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("W Góry")
                .description("Aplikacja przedstawiająca realizację dwóch przypadków użycia: \n * Zatwierdzenie odbycia wycieczki\n * Tworzenie nowej trasy punktowanej")
                .version("0.0.1")
                .contact(new Contact("Bartosz Krych", "https://github.com/bartoszkrych", "235333@student.pwr.edu.pl"))
                .build();
    }
}
