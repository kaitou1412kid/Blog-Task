package com.kritagya.blog.service;

import com.kritagya.blog.entity.User;
import com.kritagya.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserQueryService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(Long id){
        return userRepository.getReferenceById(id);
    }

}
