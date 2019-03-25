package com.v2gdemo.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "com.v2gdemo.backend")
@Configuration
@EnableWebMvc
@EnableJpaRepositories
public class GooglemapApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(GooglemapApplication.class, args);
    }
}
