package com.OnlineStudentRepository.studentcourses.service;


import com.OnlineStudentRepository.studentcourses.model.Registration;
import com.OnlineStudentRepository.studentcourses.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository registrationRepository;

    public List<Registration> readAllRegistrations()
    {
        return registrationRepository.findAll();
    }
    public List<Registration> getAllRegistrations()
    {
        List<Registration> registrationList = registrationRepository.findAll();
        return registrationList;
    }
    public Optional<Registration> getRegistrationById(int id)
    {
        Optional<Registration> regist= registrationRepository.findById(id);
        return regist;
    }
    public List<Registration> getRegistrationByDate(LocalDate date)
    {
        List<Registration> registrationList = registrationRepository.findRegistrationByDate(date);
        return registrationList;
    }
    public Registration addNewRegistration(Registration registration)
    {
        return registrationRepository.save(registration);
    }
    public Registration updateRegistration(Registration registration)
    {
        return registrationRepository.save(registration);
    }
    public void deleteRegistration(int id)
    {
        registrationRepository.deleteById(id);
    }
    public Registration addRegistration(Registration registration)
    {
        return registrationRepository.save(registration);
    }
}
