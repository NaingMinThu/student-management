package com.me.studentmanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagingResponse<T> {
    private int totalIndex;
    private long recordsTotal;
    private int recordsFiltered;
    private List<T> records;
}
