package com.kritagya.blog.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCreateRequest {

    private String text;

    private Long userId;
}
