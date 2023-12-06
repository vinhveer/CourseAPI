package com.example.courseapi.service.impl;

import com.example.courseapi.model.Personal;
import com.example.courseapi.model.Teacher;
import com.example.courseapi.payload.request.PersonalRequest;
import com.example.courseapi.repository.PersonalRepository;
import com.example.courseapi.repository.TeacherRepository;
import com.example.courseapi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    PersonalRepository personalRepository;
    @Override
    public ResponseEntity<Object> AddTeacher(PersonalRequest personalRequest) {
        Personal personal = Personal.builder()
                .firstName(personalRequest.getFirstName())
                .lastName(personalRequest.getLastName())
                .dateOfBirth(personalRequest.getDateOfBirth())
                .address(personalRequest.getAddress())
                .email(personalRequest.getEmail())
                .phone(personalRequest.getPhone())
                .build();

        personalRepository.save(personal);

        Teacher teacher = Teacher.builder()
                .personal(personal)
                .build();

        teacherRepository.save(teacher);
        return ResponseEntity.ok().body("Teacher added sucessfully!");
    }

    @Override
    public ResponseEntity<Object> GetAllTeacher() {
        return ResponseEntity.ok(teacherRepository.findAll());
    }

    @Override
    public ResponseEntity<Object> GetTeacherById(long id) {
        return ResponseEntity.ok(teacherRepository.findById(id));
    }

    @Override
    public ResponseEntity<Object> DeleteTeacherById(long id) {
        teacherRepository.deleteById(id);
        return ResponseEntity.ok().body("Delete successfully!");
    }

    @Override
    public ResponseEntity<Object> EditTeacherById(PersonalRequest personalRequest, long id) {
        Teacher updateTeacher = teacherRepository.getReferenceById(id);
        Personal personal = updateTeacher.getPersonal();
        personal.setFirstName(personalRequest.getFirstName());
        personal.setLastName(personalRequest.getLastName());
        personal.setDateOfBirth(personalRequest.getDateOfBirth());
        personal.setPhone(personalRequest.getPhone());
        personal.setEmail(personalRequest.getEmail());

        updateTeacher.setPersonal(personal);

        teacherRepository.save(updateTeacher);
        return ResponseEntity.ok().body("Update successfully!");
    }
}
