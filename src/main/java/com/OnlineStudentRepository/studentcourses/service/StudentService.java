package com.OnlineStudentRepository.studentcourses.service;

import com.OnlineStudentRepository.studentcourses.model.Student;
import com.OnlineStudentRepository.studentcourses.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> readAllStudents()
    {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public Student editStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(int id)
    {
        return studentRepository.findById(id);
    }

    public void deleteStudentById(int id)
    {
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudentsByName(String name)
    {
        return studentRepository.findAllStudentsByName(name);
    }

    public List<Student> getAllStudentsByEmail(String email)
    {
        return studentRepository.findAllStudentsByEmail(email);
    }

    public List<Student> getAllStudentByPhone(String phone)
    {
        return studentRepository.findAllStudentsByPhone(phone);
    }
}
