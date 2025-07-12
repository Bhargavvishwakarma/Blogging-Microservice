package com.bharav.notification_service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharav.notification_service.Entity.NotificationEntity;

public interface  NotificationRepository extends JpaRepository<NotificationEntity ,Long>{

    List<NotificationEntity> getNotificationsByPostId(Long id);
    
}
