package com.me.studentmanagement.controller;

import com.me.studentmanagement.dto.request.StudentRequest;
import com.me.studentmanagement.dto.request.StudnetPagingRequest;
import com.me.studentmanagement.dto.response.PagingResponse;
import com.me.studentmanagement.dto.response.StudentResponse;
import com.me.studentmanagement.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public StudentResponse findStudentById(@PathVariable("id") Long id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("/all")
    public List<StudentResponse> getAllStudent() {
        return studentService.findAllStudent();
    }

    @PostMapping("/create")
    public StudentResponse createStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.createStudent(studentRequest);
    }

    @PutMapping ("/{id}")
    public StudentResponse updateStudent(@PathVariable("id") Long id, @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(id, studentRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id")Long id) {
        studentService.deleteStudentById(id);
    }


    @GetMapping(value = "/studnetListPaging")
    public PagingResponse<StudentResponse> studentList(@RequestBody StudnetPagingRequest studnetPagingRequest) throws Exception {
        try {
            PagingResponse<StudentResponse> pagingResponse = studentService.findPaginatedStudents(studnetPagingRequest.getIndex(), studnetPagingRequest.getLength());
            return pagingResponse;
        } catch (Exception e) {
            throw new Exception("paging exception");
        }
    }
}
