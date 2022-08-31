package com.me.studentmanagement.service.impl;

import com.me.studentmanagement.datamodel.User;
import com.me.studentmanagement.repository.UserReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserAuthService implements UserDetailsService {
    @Autowired
    private UserReposity reposity;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = reposity.findByUsername(username);

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }
}
