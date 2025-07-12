package com.bhargav.like_service.DTO;

import lombok.Data;

@Data
public class NotificationEvent {
        private Long postId;
    private String type;     // "Like"
    private String message;
    private String commenter;
}
