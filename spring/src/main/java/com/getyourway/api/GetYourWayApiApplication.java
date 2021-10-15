package com.getyourway.api;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GetYourWayApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetYourWayApiApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NotNull CorsRegistry registry) {
                registry.addMapping("/weather").allowedOrigins("http://localhost:3000");
                registry.addMapping("/weather").allowedOrigins("http://99.81.186.138:3000");
            }
        };
    }
}
