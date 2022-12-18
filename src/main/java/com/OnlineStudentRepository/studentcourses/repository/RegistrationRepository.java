package com.OnlineStudentRepository.studentcourses.repository;

import com.OnlineStudentRepository.studentcourses.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

    List<Registration> findRegistrationByDate(LocalDate date);

}
