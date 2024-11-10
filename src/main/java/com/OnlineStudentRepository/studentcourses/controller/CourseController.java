package com.OnlineStudentRepository.studentcourses.controller;

import com.OnlineStudentRepository.studentcourses.model.Course;
import com.OnlineStudentRepository.studentcourses.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/allCourses")
    public List<Course> getAllCourses()
    {
        return courseService.readAllCourses();
    }

    @PostMapping("/addNewCourse")
    public ResponseEntity<Course> addCourse(@RequestBody Course course)
    {
        Course newCourse = courseService.addCourse(course);
        return ResponseEntity.ok(newCourse);
    }

    @PutMapping("/updateCourse")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course)
    {
        Course updateCourse = courseService.editCourse(course);
        return ResponseEntity.ok(updateCourse);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") int id)
    {
        courseService.getCourseById(id).orElseThrow(() -> new com.OnlineStudentRepository.exception.ResourceNotFoundException("Course with id: " + id + " " + " doesn't exist in DB!"));
        courseService.deleteCourseById(id);

        return new ResponseEntity<>("Course with id: " + id + " deleted successfully!", HttpStatus.OK);
    }

    @GetMapping("getCourseById/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id)
    {
        Course courseDB = courseService.getCourseById(id).orElseThrow(() -> new com.OnlineStudentRepository.exception.ResourceNotFoundException("Course with id " + id + " doesn't exist in database!"));
        return ResponseEntity.ok(courseDB);
    }

    @GetMapping("/getCourseByName/{name}")
    public ResponseEntity<List<Course>> getCourseByName(@PathVariable String name)
    {
        List<Course> courseList = courseService.getAllCoursesByName(name);
        if (courseList.size() == 0)
        {
            throw new com.OnlineStudentRepository.exception.ResourceNotFoundException("No products with name " + name + " not found!");
        }
        return ResponseEntity.ok(courseList);
    }

    @GetMapping("/getCourseByTeacher/{teacher}")
    public ResponseEntity<List<Course>> getCourseByTeacher(@PathVariable String teacher)
    {
        List<Course> courseList = courseService.getCourseByTeacher(teacher);
        if (courseList.size() == 0)
        {
            throw new com.OnlineStudentRepository.exception.ResourceNotFoundException("No courses with teacher: " + teacher + "found!");
        }
        return ResponseEntity.ok(courseList);
        return
    }

}
