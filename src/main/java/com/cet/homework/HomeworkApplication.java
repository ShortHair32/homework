package com.cet.homework;

import com.cet.homework.repository.impl.CustomizedRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories(repositoryBaseClass = CustomizedRepositoryImpl.class)
public class HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkApplication.class, args);
    }
   @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
   }
}
