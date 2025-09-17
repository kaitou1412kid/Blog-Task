package com.kritagya.blog.service;

import com.kritagya.blog.entity.Post;
import com.kritagya.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PostQueryService {

    @Autowired
    private PostRepository postRepository;

    public Post getPost(Long id){
        return postRepository.getReferenceById(id);
    }

    public Page<Post> getAll(PageRequest pageRequest){
        return postRepository.findAll(pageRequest);
    }
}
