package com.OnlineStudentRepository.studentcourses.controller;

import com.OnlineStudentRepository.exception.ResourceNotFoundException;
import com.OnlineStudentRepository.studentcourses.model.Registration;
import com.OnlineStudentRepository.studentcourses.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    final RegistrationService registrationService;

    @GetMapping
    public ResponseEntity<List<Registration>> getAllRegistrations()
    {
        List<Registration> registrationList = registrationService.getAllRegistrations();
        return ResponseEntity.ok(registrationList);
    }

    @GetMapping("/getRegistrationById/{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable int id)
    {
        Registration registration = registrationService.getRegistrationById(id).orElseThrow(()-> new ResourceNotFoundException("Registration with id: "+ id +" not found!"));
        return new ResponseEntity<>(registration, HttpStatus.OK);
    }

    @GetMapping("/getRegistrationByDate")
    public ResponseEntity<List<Registration>> getRegistrationByDate(@RequestParam(value = "date")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)
    {
        List<Registration> registrationList = registrationService.getRegistrationByDate(date);
        if(registrationList.size() == 0)
        {
            throw new ResourceNotFoundException("Registrations on date " + date + " not found!");
        }
        return ResponseEntity.ok(registrationList);
    }

    @PostMapping("/addNewRegistration")
    public ResponseEntity<Registration> saveRegistration(@RequestBody Registration registration)
    {
        Registration newRegistration = registrationService.addNewRegistration(registration);
        return ResponseEntity.ok(newRegistration);
    }

    @PutMapping("/updateRegistration")
    public ResponseEntity<Registration> updateRegistration(@RequestBody Registration registration)
    {
        Registration updateRegistration = registrationService.updateRegistration(registration);
        return ResponseEntity.ok(updateRegistration);
    }

    @DeleteMapping("/deleteRegistrationById/{id}")
    public ResponseEntity<?> deleteRegistrationById(@PathVariable int id)
    {
        registrationService.getRegistrationById(id).orElseThrow(()-> new ResourceNotFoundException("Registration with id: " + id +" not found"));
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>("Registration with id " + id + " deleted succesfully", HttpStatus.OK);
    }

}
