package com.teamone.socialmediaproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForm {
    private String userName;
    private String fullName;
    private String passWord;
    private String confirmPassword;
    private String phoneNumber;
    private Date birthDay;
    private String address;
    private String status;
    private String job;
    private String avatarSrc;
    private String photoCoverSrc;
    private Date startJoin;
    private String gender;
    private String email;



}
