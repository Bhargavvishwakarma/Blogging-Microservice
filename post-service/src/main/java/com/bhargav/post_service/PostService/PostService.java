package com.bhargav.post_service.PostService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bhargav.post_service.Entity.PostEntity;
import com.bhargav.post_service.PostRepository.PostRepository;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<PostEntity> getAllPosts(){
        return postRepository.findAll();
    }

    public Optional<PostEntity> getPostById(Long id){
        return postRepository.findById(id);
    }

    public PostEntity creatPost(PostEntity post){
        return postRepository.save(post);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

    public PostEntity updatePost(PostEntity updatepost){
        PostEntity post = postRepository.getById(updatepost.getId());
        if(!post.getTitle().equals(updatepost.getTitle())){
            post.setTitle(updatepost.getTitle());
        }
        if(!post.getContent().equals(updatepost.getContent())){
            post.setContent(updatepost.getContent());
        }
        post.preUpdate();
        return postRepository.save(post);
    }
}
