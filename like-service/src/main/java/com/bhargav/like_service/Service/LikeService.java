package com.bhargav.like_service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhargav.like_service.DTO.NotificationEvent;
import com.bhargav.like_service.Entity.LikeEntity;
import com.bhargav.like_service.Repository.LikeRepository;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private NotificationProducer notificationProducer;

    public LikeEntity createLike(LikeEntity likeEntity){

        NotificationEvent event = new NotificationEvent();
        event.setCommenter(likeEntity.getUser());
        event.setMessage("Liked");
        event.setPostId(likeEntity.getPostId());
        event.setType("Like");
        notificationProducer.sendNotification(event);
        return likeRepository.save(likeEntity);
    }

    public Integer getLikesByPostId(Long postId){
        List<LikeEntity> likes = likeRepository.findLikesByPostId(postId);
        return likes.size();
    }
}
