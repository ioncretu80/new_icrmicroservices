package com.example.icrscode.customer;


import com.example.icrscode.amqp.RabbitMQMessageProducer;
import com.example.icrscode.clients.fraud.FraudCheckResponse;
import com.example.icrscode.clients.fraud.FraudClient;
import com.example.icrscode.clients.notificationClient.NotificationClient;
import com.example.icrscode.clients.notificationClient.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;

//  private final RestTemplate restTemplate;
  private final FraudClient fraudClient;
//  private final NotificationClient notificationClient;

  private final RabbitMQMessageProducer rabbitMQMessageProducer;



  public void registerCustomer(CustomerRequest customerRequest){
    Customer customer = Customer.builder()
        .firstName(customerRequest.firstName())
        .lastName(customerRequest.lastName())
        .email(customerRequest.email())
        .build();
    //todo: check if email is valid
    //todo: check if isfraudster

    customerRepository.saveAndFlush(customer);

    FraudCheckResponse fraudResponse = fraudClient.isFraudster(
        customer.getId());

    if (fraudResponse.isFraudster()){
      throw new IllegalStateException("is fraudster");
    }

//    FraudCheckResponse fraudCheckResponse;
//    try{
//
//      fraudCheckResponse = restTemplate.getForObject(
//          "http://FRAUD/api/v1/fraud-check/{customerId}",
//          FraudCheckResponse.class,
//          customer.getId());
//      if(Boolean.TRUE.equals(fraudCheckResponse.isFraudster())){
//        throw new IllegalStateException("fraudster");
//      }
//
//    }catch (NullPointerException e){
//      e.printStackTrace();
//    }

  //todo: send notification

    NotificationRequest notificationRequest = new NotificationRequest(
        customer.getId(),
        customer.getEmail(),
        String.format("Hi %s, welcome to Amigoscode ...", customer.getFirstName())
    );
    //notificationClient.sendNotification(notificationRequest);

    rabbitMQMessageProducer.publish(notificationRequest,
        "internal.exchange",
        "internal.notification.routing-key"

    );

  }
}
