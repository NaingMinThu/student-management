package com.me.studentmanagement.service;

import com.me.studentmanagement.dto.request.StudentRequest;
import com.me.studentmanagement.dto.response.PagingResponse;
import com.me.studentmanagement.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse findStudentById(Long id);
    List<StudentResponse> findAllStudent();
    StudentResponse createStudent(StudentRequest studentRequest);
    StudentResponse updateStudent(Long id, StudentRequest studentRequest);
    void deleteStudentById(Long id);
    PagingResponse<StudentResponse> findPaginatedStudents(int index, int length);
    long count();
}
