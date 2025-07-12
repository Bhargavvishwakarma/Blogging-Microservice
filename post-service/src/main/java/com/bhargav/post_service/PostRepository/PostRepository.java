package com.bhargav.post_service.PostRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhargav.post_service.Entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity , Long>{

    
}