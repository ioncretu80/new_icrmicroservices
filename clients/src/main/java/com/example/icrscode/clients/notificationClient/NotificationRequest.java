package com.example.icrscode.clients.notificationClient;

public record NotificationRequest(Integer toCustomerId,
                                  String toCustomerName,
                                  String message) {

}
