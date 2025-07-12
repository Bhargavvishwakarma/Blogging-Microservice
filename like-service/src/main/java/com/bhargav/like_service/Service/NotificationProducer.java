package com.bhargav.like_service.Service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.bhargav.like_service.DTO.NotificationEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NotificationProducer {
    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public NotificationProducer(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNotification(NotificationEvent even){
        try {
            String json = objectMapper.writeValueAsString(even);
            // Replace "your-topic-name" with your actual Kafka topic name
            kafkaTemplate.send("notifications", json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
