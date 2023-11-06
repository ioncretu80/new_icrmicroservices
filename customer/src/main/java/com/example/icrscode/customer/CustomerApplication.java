package com.example.icrscode.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
    scanBasePackages = {
        "com.example.icrscode.customer",
        "com.example.icrscode.amqp"
    }
)
@EnableEurekaClient
@EnableFeignClients(
    basePackages = "com.example.icrscode.clients"
)
public class CustomerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
