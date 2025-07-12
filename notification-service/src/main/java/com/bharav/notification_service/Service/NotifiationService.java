package com.bharav.notification_service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bharav.notification_service.Entity.NotificationEntity;
import com.bharav.notification_service.Repository.NotificationRepository;

@Service
public class NotifiationService {
    
    @Autowired
    private NotificationRepository notificationRepository;

    public NotificationEntity createNotification(NotificationEntity entity){
        return notificationRepository.save(entity);
    }

    public List<NotificationEntity> getNotifications(){
        return notificationRepository.findAll();
    }

    public List<NotificationEntity> getNotificationsByPostId(Long id){
        return notificationRepository.getNotificationsByPostId(id);
    }
}
