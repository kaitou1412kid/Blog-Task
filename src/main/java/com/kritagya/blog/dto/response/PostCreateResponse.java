package com.kritagya.blog.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostCreateResponse {
    private String title;

    private String content;

    private LocalDateTime timeStamp;
}
