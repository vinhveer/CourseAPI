package com.example.courseapi.service.impl;

import com.example.courseapi.model.Course;
import com.example.courseapi.model.Subject;
import com.example.courseapi.model.Teacher;
import com.example.courseapi.payload.request.CourseRequest;
import com.example.courseapi.repository.CourseRepository;
import com.example.courseapi.repository.SubjectRepository;
import com.example.courseapi.repository.TeacherRepository;
import com.example.courseapi.service.CourseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public ResponseEntity<Object> AddCourse(CourseRequest courseRequest) {
        Subject subject = subjectRepository.getReferenceById(courseRequest.getSubjectId());
        Teacher teacher = teacherRepository.getReferenceById(courseRequest.getTeacherId());
        Course course = Course.builder()
                .courseName(courseRequest.getCourseName())
                .subject(subject)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
        return ResponseEntity.ok().body("Add course successfully!");
    }

    @Override
    public ResponseEntity<Object> GetAllCourse() {
        return ResponseEntity.ok(courseRepository.findAll());
    }

    @Override
    public ResponseEntity<Object> GetCourseById(long id) {
        return ResponseEntity.ok(courseRepository.findById(id));
    }

    @Override
    public ResponseEntity<Object> DeleteCourseById(long id) {
        courseRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully!");
    }

    @Override
    public ResponseEntity<Object> EditCourseById(CourseRequest courseRequest, long id) {
        // Kiểm tra xem course có tồn tại hay không
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + id));

        // Lấy references của Subject và Teacher từ repository
        Subject subject = subjectRepository.getReferenceById(courseRequest.getSubjectId());
        Teacher teacher = teacherRepository.getReferenceById(courseRequest.getTeacherId());

        // Cập nhật thông tin của course
        existingCourse.setCourseName(courseRequest.getCourseName());
        existingCourse.setSubject(subject);
        existingCourse.setTeacher(teacher);

        // Lưu lại thông tin đã cập nhật
        courseRepository.save(existingCourse);

        return ResponseEntity.ok("Update successfully!");
    }

}
