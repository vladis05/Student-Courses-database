package com.OnlineStudentRepository.studentcourses.repository;

import com.OnlineStudentRepository.studentcourses.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllStudentsByName(String name);
    List<Student> findAllStudentsByEmail(String email);
    List<Student> findAllStudentsByPhone(String phone);
    List<Student> findAll();
}
