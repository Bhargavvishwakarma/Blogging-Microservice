package com.bharav.comment_service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bharav.comment_service.DTO.NotificationEvent;
import com.bharav.comment_service.Entity.CommentEntity;
import com.bharav.comment_service.Repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private NotificationProducer notificationProducer;
    private final PostClient postClient;

    public CommentService(CommentRepository repository, PostClient postClient) {
        this.postClient = postClient;
    }

    public CommentEntity createComment(CommentEntity comment) {
        try {
            if(postClient.getPostById(comment.getPostId()) == null){
               throw new IllegalArgumentException();
            }
            
            System.out.println(postClient.getPostById(comment.getPostId()));
            NotificationEvent event = new NotificationEvent();
            event.setMessage(comment.getContent());
            event.setType("Comment");
            event.setCommenter(comment.getCommenterName());
            event.setPostId(comment.getPostId());
            notificationProducer.sendNotification(event);
        } catch (Exception e) {
            throw new IllegalArgumentException("Post with ID " + comment.getPostId() + " does not exist.");
        }

        return commentRepository.save(comment);
    }

    public List<CommentEntity> getCommentByPostId(Long postId) {

        return commentRepository.findByPostId(postId);
    }

    public void deleteCommnetById(Long commentId) {
        commentRepository.deleteById(commentId);
    }

}
