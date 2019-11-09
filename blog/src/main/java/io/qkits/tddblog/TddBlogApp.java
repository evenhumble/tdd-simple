package io.qkits.tddblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TddBlogApp {

    public static void main(String[] args) {
        SpringApplication.run(TddBlogApp.class,args);
    }
}
