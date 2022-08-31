package com.me.studentmanagement.mapper;

import com.me.studentmanagement.datamodel.Student;
import com.me.studentmanagement.dto.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);
    StudentResponse bindDataModelToResponse(Student student);
    List<StudentResponse> bindDataModelListToResponseList(List<Student> studentList);
}
