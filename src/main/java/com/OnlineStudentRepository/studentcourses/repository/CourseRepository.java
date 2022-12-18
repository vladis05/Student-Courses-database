package com.OnlineStudentRepository.studentcourses.repository;

import com.OnlineStudentRepository.studentcourses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findAllCoursesByName(String name);
    List<Course> findAllCoursesByTeacher( String teacher);
    List<Course> findAll();

}
