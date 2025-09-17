package com.kritagya.blog.service;

import com.kritagya.blog.entity.Comment;
import com.kritagya.blog.entity.Post;
import com.kritagya.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CommentQueryService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentByPost(Post post){
        return commentRepository.findByPostId(post);
    }

    public List<Comment> getAll(){
        return commentRepository.findAll();
    }
}
