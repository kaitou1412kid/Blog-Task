package com.kritagya.blog.service;

import com.kritagya.blog.dto.request.UserCreateRequest;
import com.kritagya.blog.dto.response.UserCreateResponse;
import com.kritagya.blog.entity.User;
import com.kritagya.blog.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserCreateResponse createUser(UserCreateRequest request){
        User user = new User();

        user.setEmail(request.getEmail());
        user.setName(request.getName());

        userRepository.save(user);

        UserCreateResponse response = new UserCreateResponse();

        response.setName(user.getName());
        response.setEmail(user.getEmail());

        return response;
    }
}
