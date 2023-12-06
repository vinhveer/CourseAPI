package com.example.courseapi.payload.request;

import lombok.Data;

@Data
public class GradeRequest {
    private long id;

    private long studentId;

    private long courseId;

    private float processGrade;

    private float midtermGrade;

    private float finalGrade;
}
