package com.bharav.notification_service.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Data
@Entity
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long postId;
    private String type;
    private String message;
    private String commnter;
    private LocalDateTime createdAt;

    @PrePersist
    private void prePersit(){
        createdAt = LocalDateTime.now();
    }
}
