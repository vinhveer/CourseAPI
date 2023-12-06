package com.example.courseapi.service.impl;

import com.example.courseapi.model.Personal;
import com.example.courseapi.model.Student;
import com.example.courseapi.payload.request.PersonalRequest;
import com.example.courseapi.repository.PersonalRepository;
import com.example.courseapi.repository.StudentRepository;
import com.example.courseapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    PersonalRepository personalRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public ResponseEntity<Object> AddStudent(PersonalRequest personalRequest) {
        Personal personal = Personal.builder()
                .firstName(personalRequest.getFirstName())
                .lastName(personalRequest.getLastName())
                .dateOfBirth(personalRequest.getDateOfBirth())
                .address(personalRequest.getAddress())
                .email(personalRequest.getEmail())
                .phone(personalRequest.getPhone())
                .build();

        personalRepository.save(personal);

        Student student = Student.builder()
                .personal(personal)
                .build();

        studentRepository.save(student);
        return ResponseEntity.ok().body("Student added sucessfully!");
    }

    @Override
    public ResponseEntity<Object> GetAllStudent() {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @Override
    public ResponseEntity<Object> GetStudentById(long id) {
        return ResponseEntity.ok(studentRepository.findById(id));
    }

    @Override
    public ResponseEntity<Object> DeleteStudentById(long id) {
        studentRepository.deleteById(id);
        return ResponseEntity.ok().body("Delete successfully!");
    }

    @Override
    public ResponseEntity<Object> EditStudentById(PersonalRequest personalRequest, long id) {
        Student updateStudent = studentRepository.getReferenceById(id);
        Personal personal = updateStudent.getPersonal();
        personal.setFirstName(personalRequest.getFirstName());
        personal.setLastName(personalRequest.getLastName());
        personal.setDateOfBirth(personalRequest.getDateOfBirth());
        personal.setPhone(personalRequest.getPhone());
        personal.setEmail(personalRequest.getEmail());

        updateStudent.setPersonal(personal);

        studentRepository.save(updateStudent);
        return ResponseEntity.ok().body("Update successfully!");
    }
}
