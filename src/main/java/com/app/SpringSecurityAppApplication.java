package com.app;

import com.app.config.DotenvConfig;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityAppApplication {

    static{
        //Carregar el .env abans que Spring Boot arrenqui
        Dotenv dotenv= Dotenv.load();
        System.setProperty("DB_USER", dotenv.get("DB_USER"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("JWT_KEY", dotenv.get("JWT_KEY"));
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityAppApplication.class, args);
    }
}
