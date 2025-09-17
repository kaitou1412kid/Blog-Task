package com.kritagya.blog.dto.response;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private String message;

    private T data;
}
