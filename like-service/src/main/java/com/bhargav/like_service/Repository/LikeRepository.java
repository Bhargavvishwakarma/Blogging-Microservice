package com.bhargav.like_service.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhargav.like_service.Entity.LikeEntity;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity,Long> {

    List<LikeEntity> findLikesByPostId(Long postId);
    
}
