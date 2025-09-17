package com.kritagya.blog.service;

import com.kritagya.blog.dto.request.CommentCreateRequest;
import com.kritagya.blog.dto.request.PostCreateRequest;
import com.kritagya.blog.dto.response.CommentCreateResponse;
import com.kritagya.blog.dto.response.PostCreateResponse;
import com.kritagya.blog.dto.response.PostListResponse;
import com.kritagya.blog.dto.response.PostResponse;
import com.kritagya.blog.entity.Comment;
import com.kritagya.blog.entity.Post;
import com.kritagya.blog.entity.User;
import com.kritagya.blog.repository.CommentRepository;
import com.kritagya.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserQueryService userQueryService;

    @Autowired
    private PostQueryService postQueryService;

    @Autowired
    private CommentQueryService commentQueryService;

    public PostCreateResponse createPost(PostCreateRequest request){
        User user = userQueryService.getUser(request.getUserId());
        Post post = new Post();

        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setCreatedAt(LocalDateTime.now());
        post.setUserId(user);

        postRepository.save(post);

        PostCreateResponse response = new PostCreateResponse();

        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setTimeStamp(post.getCreatedAt());

        return response;
    }

    public CommentCreateResponse postComment(CommentCreateRequest request, Long postId){
        User user = userQueryService.getUser(request.getUserId());
        Post post = postQueryService.getPost(postId);

        Comment comment = new Comment();

        comment.setText(request.getText());
        comment.setPostId(post);
        comment.setUserId(user);
        comment.setCreatedAt(LocalDateTime.now());

        commentRepository.save(comment);

        CommentCreateResponse response = new CommentCreateResponse();

        response.setText(comment.getText());
        response.setTimeStamp(comment.getCreatedAt());

        return response;
    }

    public PostResponse getPost(Long postId){
        Post post = postQueryService.getPost(postId);

        List<Comment> comments = commentQueryService.getCommentByPost(postId);

        PostResponse response = new PostResponse();
        List<PostResponse.CommentResponse> commentResponseList = new ArrayList<>();

        response.setContent(post.getContent());
        response.setUsername(post.getUserId().getName());

        comments.forEach(comment -> {
            PostResponse.CommentResponse commentResponse = new PostResponse.CommentResponse();
            commentResponse.setText(comment.getText());
            commentResponse.setUsername(comment.getUserId().getName());
            commentResponse.setTimeStamp(comment.getCreatedAt());

            commentResponseList.add(commentResponse);
        });

        response.setComments(commentResponseList);

        return response;
    }


    public Page<PostListResponse> getAllPost(int page, int size){
        PageRequest pageRequest = PageRequest.of(page,size);
        Page<Post> posts = postQueryService.getAll(pageRequest);

        List<PostListResponse> postListResponses = new ArrayList<>();

        posts.forEach(post -> {
            PostListResponse response = new PostListResponse();

            response.setTitle(post.getTitle());
            response.setContent(post.getContent());
            response.setAuthorName(post.getUserId().getName());
            response.setCommentCount(post.getComments().size());

            postListResponses.add(response);
        });

        return new PageImpl<>(postListResponses, pageRequest, posts.getTotalElements());
    }

}
