package com.kritagya.blog.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentCreateResponse {

    private String text;

    private LocalDateTime timeStamp;
}
