package com.example.icrscode.fraud;


import com.icrcode.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/fraud-check")
@AllArgsConstructor
public class FraudController{

  private FraudCheckService fraudCheckService;


  @GetMapping(path = "{customerId}")
  public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerID){
    log.info("fraud check request for customer {}", customerID);
    boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerID);
    return new FraudCheckResponse(isFraudulentCustomer);
  }

}
