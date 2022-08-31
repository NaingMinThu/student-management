package com.me.studentmanagement.service;

import com.me.studentmanagement.datamodel.User;
import com.me.studentmanagement.dto.response.UserResponse;

public interface UserService {
    UserResponse findUserById(Long id);
    UserResponse findUserByUsername(String userName);
    UserResponse save(User user);
    long count();
}
