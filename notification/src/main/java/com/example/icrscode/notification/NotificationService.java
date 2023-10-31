package com.example.icrscode.notification;

import com.icrcode.clients.notification.NotificationRequest;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {
  public final NotificationRepository notificationRepository;

  public void sendNotification(NotificationRequest notificationRequest) {
    notificationRepository.save(Notification.builder()
            .toCustomerId(notificationRequest.toCustomerId())
            .toCustomerEmail(notificationRequest.toCustomerName())
            .sender("icrsCode")
            .message(notificationRequest.message())
            .sentAt(LocalDateTime.now())
        .build());
  }
}
