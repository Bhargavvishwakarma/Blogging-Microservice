package com.bharav.comment_service.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharav.comment_service.Entity.CommentEntity;
import com.bharav.comment_service.Service.CommentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/comments")
public class commentController {

    @Autowired
    private CommentService commentService;

    @PostMapping()
    public ResponseEntity<CommentEntity> createComment(@RequestBody CommentEntity entity) {
        return ResponseEntity.ok(commentService.createComment(entity));
    
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CommentEntity>> getCommentByPostId(@PathVariable("id") Long postId) {
        return ResponseEntity.ok(commentService.getCommentByPostId(postId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCommentById(@PathVariable("id") Long postId) {
        commentService.deleteCommnetById(postId);
        return ResponseEntity.ok("Deleted");
    }
}
