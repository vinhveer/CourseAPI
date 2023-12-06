package com.example.courseapi.payload.request;

import lombok.Data;

@Data
public class CourseRequest {
    private long id;

    private String courseName;

    private long subjectId;

    private long teacherId;
}
