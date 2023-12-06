package com.example.courseapi.payload.request;

import lombok.Data;

@Data
public class SubjectRequest {
    private long subjectId;

    private String subjectName;

    private int credit;
}
