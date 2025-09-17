package com.kritagya.blog.controller;

import com.kritagya.blog.dto.request.UserCreateRequest;
import com.kritagya.blog.dto.response.UserCreateResponse;
import com.kritagya.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserCreateResponse> createUser(@RequestBody UserCreateRequest request){
        UserCreateResponse response = userService.createUser(request);
        return ResponseEntity.ok(response);
    }
}
