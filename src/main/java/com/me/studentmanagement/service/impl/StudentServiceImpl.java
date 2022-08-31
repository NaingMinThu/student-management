package com.me.studentmanagement.service.impl;

import com.me.studentmanagement.datamodel.Student;
import com.me.studentmanagement.dto.request.StudentRequest;
import com.me.studentmanagement.dto.response.PagingResponse;
import com.me.studentmanagement.dto.response.StudentResponse;
import com.me.studentmanagement.mapper.StudentMapper;
import com.me.studentmanagement.repository.StudentRepository;
import com.me.studentmanagement.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentResponse findStudentById(Long id) {
        Student student = repo.findByID(id);
        if(student == null) {
            return null;
        }
        return StudentMapper.MAPPER.bindDataModelToResponse(student);
    }

    @Override
    public List<StudentResponse> findAllStudent() {
        List<Student> studentList = repo.getAllStudent();

        if(studentList.isEmpty()){
            return null;
        }

        return StudentMapper.MAPPER.bindDataModelListToResponseList(studentList);
    }

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setFullName(studentRequest.getFullName());
        student.setGender(studentRequest.getGender());
        student.setDateOfBirth(studentRequest.getDateOfBirth());
        student.setAddress(studentRequest.getAddress());
        student.setCreatedUserId(0);
        student.setCreatedDate(new Date());
        repo.save(student);

        return StudentMapper.MAPPER.bindDataModelToResponse(student);
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
        Optional<Student> checkStudent = repo.findById(id);

        if(!checkStudent.isPresent()){
            return null;
        }

        Student oldStudent = checkStudent.get();
        if(oldStudent.getVersion() != studentRequest.getVersion()){
            return null;
        }

        oldStudent.setFullName(studentRequest.getFullName());
        oldStudent.setGender(studentRequest.getGender());
        oldStudent.setDateOfBirth(studentRequest.getDateOfBirth());
        oldStudent.setAddress(studentRequest.getAddress());
        oldStudent.setUpdatedUserId(0);
        oldStudent.setUpdatedDate(new Date());

        repo.save(oldStudent);

        return StudentMapper.MAPPER.bindDataModelToResponse(oldStudent);
    }

    @Override
    public void deleteStudentById(Long id) {
        repo.deleteByID(id);
    }

    public PagingResponse<StudentResponse> findPaginatedStudents(int index, int length) throws NumberFormatException {
        List<StudentResponse> studentResponseList = new ArrayList<>();
        Long totalCount = repo.count();
        int count = (int) ((length < 0) ? totalCount : length);
        PageRequest page = PageRequest.of(index, count);

        Page<Student> students = repo.getAllStudentPagable(page);
        List<Student> studentList  = students.getContent();

        studentResponseList = StudentMapper.MAPPER.bindDataModelListToResponseList(studentList);

        return new PagingResponse<StudentResponse>(students.getTotalPages(), students.getTotalElements(),
                students.getNumberOfElements(), studentResponseList);
    }

    @Override
    public long count() {
        return repo.countOfStudent();
    }
}
