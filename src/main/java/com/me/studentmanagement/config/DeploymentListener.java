package com.me.studentmanagement.config;

import com.me.studentmanagement.datamodel.User;
import com.me.studentmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.Date;

@Component
public class DeploymentListener {
    @Autowired
    private UserService userService;

    @PostConstruct
    public void execute() throws SQLException {
        if(userService.count() <= 0){
            User user = new User();
            user.setUserName("admin");
            user.setPassword("password");
            user.setCreatedDate(new Date());
            user.setCreatedUserId(1);
            userService.save(user);
        }
    }
}
