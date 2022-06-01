package com.amigoscode.notification;

import com.amigoscode.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Integer saveNotification(NotificationRequest notificationRequest) {

        final Notification notification = Notification.builder()
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .sender("Customer service")
                .message(notificationRequest.message())
                .sentAt(LocalDateTime.now()).build();

        final Notification notification1 = notificationRepository.saveAndFlush(notification);


        return notification1.getNotificationId();
    }
}
