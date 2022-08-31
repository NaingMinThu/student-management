package com.me.studentmanagement.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StudentRequest implements Serializable {
    private String fullName;
    private String gender;
    private Date dateOfBirth;
    private String address;
    private int version;
}
