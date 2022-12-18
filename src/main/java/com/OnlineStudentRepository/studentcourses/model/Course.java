package com.OnlineStudentRepository.studentcourses.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "course_name")
    private String name;
    @Column(name = "course_teacher")
    private String teacher;

    @JsonIgnore
    @ManyToMany(mappedBy = "courses")
    List<Registration> registrations;
}
