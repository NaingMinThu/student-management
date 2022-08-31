package com.me.studentmanagement.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudnetPagingRequest implements Serializable {
    private int index;
    private int length;
}
