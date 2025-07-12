package com.bhargav.like_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.bhargav.like_service.Entity.LikeEntity;
import com.bhargav.like_service.Service.LikeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("api/likes")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping()
    public ResponseEntity<LikeEntity> createLike(@RequestBody LikeEntity like) {
        return ResponseEntity.ok(likeService.createLike(like));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Integer> getLikes(@PathVariable Long postId) {
        return ResponseEntity.ok(likeService.getLikesByPostId(postId));
    }
}
