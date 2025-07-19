package com.bhargav.post_service.Contoller;

import org.springframework.web.bind.annotation.RestController;

import com.bhargav.post_service.Entity.PostEntity;
import com.bhargav.post_service.PostService.PostService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping()
    public ResponseEntity<List<PostEntity>> getMethodName() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<PostEntity>> getPostById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostById(id));
    }

    @PostMapping
    public ResponseEntity<PostEntity> create(@RequestBody PostEntity post) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.creatPost(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostEntity> update(@PathVariable Long id, @RequestBody PostEntity post) {
        post.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(postService.updatePost(post));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postService.deletePost(id);
    }
    
}
