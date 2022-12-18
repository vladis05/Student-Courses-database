package com.OnlineStudentRepository.studentcourses.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "registrations")
@Data
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "registration_description")
    private String description;
    LocalDate date;

    @ManyToMany
    @JoinTable(
            name = "COURSES_REGISTRATIONS",
            joinColumns = @JoinColumn(name = "REGISTRATION_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID")
    )
    List<Course> courses;

}
