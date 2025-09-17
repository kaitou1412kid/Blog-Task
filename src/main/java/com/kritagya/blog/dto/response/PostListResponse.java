package com.kritagya.blog.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostListResponse {
    private String title;

    private String content;

    private String authorName;

    private LocalDateTime createdAt;

    private int commentCount;
}
