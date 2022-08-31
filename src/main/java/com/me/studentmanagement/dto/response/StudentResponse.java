package com.me.studentmanagement.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StudentResponse implements Serializable {
    private Long id;
    private String fullName;
    private String gender;
    private Date dateOfBirth;
    private String address;
}
