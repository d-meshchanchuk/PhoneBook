package com.myproject.phonebook.dto;

import lombok.Data;

@Data
public class RegistrationUserDto {
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private String firstName;
    private String lastName;
    private String photoUrl;
}
