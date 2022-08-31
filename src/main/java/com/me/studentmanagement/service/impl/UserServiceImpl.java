package com.me.studentmanagement.service.impl;

import com.me.studentmanagement.datamodel.User;
import com.me.studentmanagement.dto.response.UserResponse;
import com.me.studentmanagement.mapper.UserMapper;
import com.me.studentmanagement.repository.UserReposity;
import com.me.studentmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserReposity repo;

    @Override
    public UserResponse findUserById(Long id) {
        User user = repo.getById(id);
        if(user == null) {
            return null;
        }
        return UserMapper.MAPPER.bindDataModelToResponse(user);
    }

    @Override
    public UserResponse findUserByUsername(String userName) {
        User user = repo.findByUsername(userName);
        if(user == null) {
            return null;
        }
        return UserMapper.MAPPER.bindDataModelToResponse(user);
    }

    @Override
    public UserResponse save(User user) {
        repo.save(user);
        return UserMapper.MAPPER.bindDataModelToResponse(user);
    }

    @Override
    public long count() {
        return repo.count();
    }
}
