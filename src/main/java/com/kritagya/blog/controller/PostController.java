package com.kritagya.blog.controller;

import com.kritagya.blog.dto.request.CommentCreateRequest;
import com.kritagya.blog.dto.request.PostCreateRequest;
import com.kritagya.blog.dto.response.CommentCreateResponse;
import com.kritagya.blog.dto.response.PostCreateResponse;
import com.kritagya.blog.dto.response.PostListResponse;
import com.kritagya.blog.dto.response.PostResponse;
import com.kritagya.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("")
    public ResponseEntity<PostCreateResponse> createPost(@RequestBody PostCreateRequest request){
        PostCreateResponse response = postService.createPost(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{post_id}/comments")
    public ResponseEntity<CommentCreateResponse> postComment(@RequestBody CommentCreateRequest request, @PathVariable("post_id") Long postId){
        CommentCreateResponse response = postService.postComment(request, postId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{post_id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable("post_id") Long postId){
        PostResponse response = postService.getPost(postId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("")
    public ResponseEntity<Page<PostListResponse>> getAll(@RequestParam int page, @RequestParam int size){
        Page<PostListResponse> response = postService.getAllPost(page,size);
        return ResponseEntity.ok(response);
    }

}
