package com.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig {

    @Bean
    public WebMvcConfigurer CORSConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**")
                        //.allowedOrigins("http://localhost:4200")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT","DELETE", "OPTIONS")
                		.allowedHeaders("*");
            }
        };
    }

}