package com.kritagya.blog.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PostResponse {

    private String content;

    private String username;

    private List<CommentResponse> comments;

    @Getter
    @Setter
    public static class CommentResponse {

        private String text;

        private LocalDateTime timeStamp;

        private String username;
    }
}
