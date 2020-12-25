package com.kedele.springboot.lab.consumer;


import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class ConsumerApplication implements GreetingController{
    @Autowired
    private EurekaClient eurekaClient;
    @Value("${spring.application.name}")
    private String appName;
    


    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    public String greeting() {
        return String.format(
                "Hello from '%s'!", eurekaClient.getApplication(appName).getName());
    }
}
