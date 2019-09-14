package io.qdriven.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class HelloWorldApp {
    public static void main(String[] args) {
        for (String arg : args) {
            log.info("start up arguments,arg:{}",arg);
        }
        SpringApplication.run(HelloWorldApp.class,args);
    }
}
