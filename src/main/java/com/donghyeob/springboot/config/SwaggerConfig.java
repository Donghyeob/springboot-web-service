package com.donghyeob.springboot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI springOpenApi() {
        return new OpenAPI().info(new Info().title("API"));
    }
    @Bean
    public GroupedOpenApi springApiV1() {
        return GroupedOpenApi.builder()
                .group("Spring-Api-V1")
                .pathsToMatch("/**")
                .build();
    }
}
