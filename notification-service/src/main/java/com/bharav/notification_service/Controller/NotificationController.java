package com.bharav.notification_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.bharav.notification_service.Entity.NotificationEntity;
import com.bharav.notification_service.Service.NotifiationService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("api/notifications")
public class NotificationController {
    
    @Autowired
    private NotifiationService notifationService;

    @PostMapping()
    public ResponseEntity<NotificationEntity> createNotification(@RequestBody NotificationEntity entity) {
        return ResponseEntity.ok(notifationService.createNotification(entity));
    }

    @GetMapping()
    public ResponseEntity<List<NotificationEntity>> getAllNotifications() {
        return ResponseEntity.ok(notifationService.getNotifications());
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<NotificationEntity>> getAllNotificationsBypostId(@PathVariable Long id) {
        return ResponseEntity.ok(notifationService.getNotificationsByPostId(id));
    }
    
}
