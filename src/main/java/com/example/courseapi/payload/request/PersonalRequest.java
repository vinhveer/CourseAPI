package com.example.courseapi.payload.request;

import lombok.Data;

import java.util.Date;

@Data
public class PersonalRequest {
    private long id;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String address;

    private String email;

    private String phone;
}
