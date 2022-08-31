package com.me.studentmanagement.dto.response;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String fullName;
    private String userName;
    private String password;
}
