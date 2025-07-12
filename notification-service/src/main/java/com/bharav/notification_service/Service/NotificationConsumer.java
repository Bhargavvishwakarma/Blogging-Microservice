package com.bharav.notification_service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.bharav.notification_service.Service.NotifiationService;
import com.bharav.notification_service.DTO.NotificationEvent;
import com.bharav.notification_service.Entity.NotificationEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class NotificationConsumer {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private NotifiationService notifiationService;

    

    @KafkaListener(topics = "notifications", groupId = "notification-group")
    public void listen(String message) {
        try {
            NotificationEvent event = objectMapper.readValue(message, NotificationEvent.class);
            System.out.println("Notification received: " + event.getMessage() + " By " + event.getCommenter());
            NotificationEntity entity = new NotificationEntity();
            entity.setMessage(event.getMessage());
            entity.setCommnter(event.getCommenter());
            entity.setPostId(event.getPostId());
            entity.setType(event.getType());
            notifiationService.createNotification(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
