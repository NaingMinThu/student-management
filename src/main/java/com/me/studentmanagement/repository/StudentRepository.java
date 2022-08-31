package com.me.studentmanagement.repository;

import com.me.studentmanagement.datamodel.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.isDelete = false AND s.id = :id")
    Student findByID(Long id);

    @Query("SELECT s FROM Student s WHERE s.isDelete = false")
    List<Student> getAllStudent();

    @Query("SELECT s FROM Student s WHERE s.isDelete = false")
    Page<Student> getAllStudentPagable(Pageable page);

    @Modifying
    @Query("UPDATE Student s SET s.isDelete = true WHERE s.id = :id")
    void deleteByID(Long id);

    @Query("SELECT count(s.id)  as Count FROM Student s WHERE s.isDelete = false")
    long countOfStudent();
}
