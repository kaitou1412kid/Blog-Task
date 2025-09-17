package com.kritagya.blog.repository;

import com.kritagya.blog.entity.Comment;
import com.kritagya.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostId(Post post);
}
