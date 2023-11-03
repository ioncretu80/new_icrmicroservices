package com.example.icrscode.clients.notificationClient;

import com.example.icrscode.clients.fraud.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification")
public interface NotificationClient {

  @GetMapping(path = "api/v1/notification/")
  FraudCheckResponse sendNotification(
      @RequestBody() NotificationRequest notificationRequest);



}
