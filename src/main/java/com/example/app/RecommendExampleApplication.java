package com.example.app;

import com.example.app.config.properties.DabangDatabaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(value = {DabangDatabaseProperties.class})
@SpringBootApplication
public class RecommendExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecommendExampleApplication.class, args);
    }

}
