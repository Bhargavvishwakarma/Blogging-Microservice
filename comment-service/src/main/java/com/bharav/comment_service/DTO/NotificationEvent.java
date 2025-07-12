package com.bharav.comment_service.DTO;

import lombok.Data;

@Data
public class NotificationEvent {
    private Long postId;
    private String type;     // "COMMENT"
    private String message;
    private String commenter;
}
