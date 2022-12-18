package com.OnlineStudentRepository.studentcourses.controller;


import com.OnlineStudentRepository.studentcourses.model.Student;
import com.OnlineStudentRepository.studentcourses.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/allStudents")
    public List<Student> getAllStudents()
    {
        return studentService.readAllStudents();
    }

    @PostMapping("/addNewStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student)
    {
        Student newStudent = studentService.addStudent(student);
        return ResponseEntity.ok(newStudent);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student)
    {
        Student updateStudent = studentService.editStudent(student);
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id")int id)
    {
        studentService.getStudentById(id).orElseThrow(()-> new com.OnlineStudentRepository.exception.ResourceNotFoundException("Student with id: " + id + " " + " doesn't exist in DB!"));
        studentService.deleteStudentById(id);

        return new ResponseEntity<>("Student with id: "+id+" deleted succesfully!", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id)
    {
        Student studentDB= studentService.getStudentById(id).orElseThrow(()-> new com.OnlineStudentRepository.exception.ResourceNotFoundException("Product with id " + id + " doesn't exist in database!"));
        return ResponseEntity.ok(studentDB);
    }

    @GetMapping("/getAllStudentsByName/{name}")
    public ResponseEntity<List<Student>> getStudentsByName(@PathVariable String name)
    {
        List<Student> studentList = studentService.getAllStudentsByName(name);
        if (studentList.size() == 0)
        {
            throw new com.OnlineStudentRepository.exception.ResourceNotFoundException("No students with name " + name + " not found!");
        }
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/getAllStudentsByEmail/{email}")
    public ResponseEntity<List<Student>> getStudentsByEmail(@PathVariable String email)
    {
        List<Student> studentList = studentService.getAllStudentsByEmail(email);
        if (studentList.size() == 0)
        {
            throw new com.OnlineStudentRepository.exception.ResourceNotFoundException("No students with name " + email + " not found!");
        }
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/getAllStudentsByPhone/{phone}")
    public ResponseEntity<List<Student>> getStudentsByPhone(@PathVariable String phone)
    {
        List<Student> studentList = studentService.getAllStudentByPhone(phone);
        if (studentList.size() == 0)
        {
            throw new com.OnlineStudentRepository.exception.ResourceNotFoundException("No students with name " + phone + " not found!");
        }
        return ResponseEntity.ok(studentList);
    }
}
