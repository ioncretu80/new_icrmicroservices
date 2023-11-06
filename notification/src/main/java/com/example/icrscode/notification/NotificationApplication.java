package com.example.icrscode.notification;


import com.example.icrscode.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {
    "com.example.icrscode.notification",
    "com.example.icrscode.amqp"
})
@EnableEurekaClient
public class NotificationApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(NotificationApplication.class, args);
    }
//   @Bean
//   CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer,
//        NotificationConfig notificationConfig){
//        return args ->{
//
//            producer.publish(
//                new Person("Ion", "Cretu"),
//                notificationConfig.getInternalExchange(),
//                notificationConfig.getInternalNotificationRoutingKey());
//        };
//    }
//
//
//    private record Person(String firstName, String lastName){}
}
