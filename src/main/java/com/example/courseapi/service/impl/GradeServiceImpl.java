package com.example.courseapi.service.impl;

import com.example.courseapi.model.Course;
import com.example.courseapi.model.Grade;
import com.example.courseapi.model.Student;
import com.example.courseapi.payload.request.GradeRequest;
import com.example.courseapi.repository.CourseRepository;
import com.example.courseapi.repository.GradeRepository;
import com.example.courseapi.repository.StudentRepository;
import com.example.courseapi.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public ResponseEntity<Object> AddGrade(GradeRequest gradeRequest) {
        Student student = studentRepository.getReferenceById(gradeRequest.getStudentId());
        Course course = courseRepository.getReferenceById(gradeRequest.getCourseId());

        Grade grade = Grade.builder()
                .course(course)
                .student(student)
                .finalGrade(gradeRequest.getFinalGrade())
                .midtermGrade(gradeRequest.getMidtermGrade())
                .processGrade(gradeRequest.getProcessGrade())
                .build();

        gradeRepository.save(grade);

        return ResponseEntity.ok("Add grade successfully!");
    }

    @Override
    public ResponseEntity<Object> GetAllGrade() {
        return ResponseEntity.ok(gradeRepository.findAll());
    }

    @Override
    public ResponseEntity<Object> GetGradeById(long id) {
        return ResponseEntity.ok(gradeRepository.findById(id));
    }

    @Override
    public ResponseEntity<Object> DeleteGradeById(long id) {
        gradeRepository.deleteById(id);
        return ResponseEntity.ok("Grade delete successfully!");
    }

    @Override
    public ResponseEntity<Object> EditGradeById(GradeRequest gradeRequest, long id) {
        Student updateStudent = studentRepository.getReferenceById(gradeRequest.getStudentId());
        Course updateCourse = courseRepository.getReferenceById(gradeRequest.getCourseId());
        Grade updateGrade = gradeRepository.getReferenceById(id);

        updateGrade.setProcessGrade(gradeRequest.getProcessGrade());
        updateGrade.setMidtermGrade(gradeRequest.getMidtermGrade());
        updateGrade.setFinalGrade(gradeRequest.getFinalGrade());
        updateGrade.setStudent(updateStudent);
        updateGrade.setCourse(updateCourse);

        gradeRepository.save(updateGrade);
        return ResponseEntity.ok("Edit grade successfully!");
    }
}
