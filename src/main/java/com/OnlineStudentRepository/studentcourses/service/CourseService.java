package com.OnlineStudentRepository.studentcourses.service;

import com.OnlineStudentRepository.studentcourses.model.Course;
import com.OnlineStudentRepository.studentcourses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> readAllCourses()
    {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(int id)
    {
        return courseRepository.findById(id);
    }

    public Course addCourse(Course course)
    {
        return courseRepository.save(course);
    }

    public Course editCourse(Course course)
    {
        return courseRepository.save(course);
    }

    public void deleteCourseById(int id)
    {
        courseRepository.deleteById(id);
    }


    public List<Course> getAllCoursesByName(String name)
    {
        return courseRepository.findAllCoursesByName(name);
    }

    public List<Course> getCourseByTeacher(String teacher)
    {
        return courseRepository.findAllCoursesByTeacher(teacher);
    }
}
