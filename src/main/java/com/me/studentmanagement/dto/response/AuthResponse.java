package com.me.studentmanagement.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthResponse implements Serializable {
    private String responseMessage;
    private String token;
}
