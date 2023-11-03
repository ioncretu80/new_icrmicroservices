package com.example.icrscode.fraud;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FraudCheckService {

  private final FraudCheckHistoryRepository repository;
  public boolean isFraudulentCustomer(Integer customerId){


  repository.save(FraudCheckHistory.builder()
      .customerId(customerId)
      .isFraudster(false)
      .createdAt(LocalDateTime.now()).build());
  return false;

  }

}
