package com.example.edutech.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class EdutechConfig {
    @Bean
    public OpenAPI customAPI(){
        return new OpenAPI()
                .info(new Info()
                .title("API Edutech")
                .version("1.0")
                .description("Documentacion de la API para el sistema de Edutech"));
    }

}
