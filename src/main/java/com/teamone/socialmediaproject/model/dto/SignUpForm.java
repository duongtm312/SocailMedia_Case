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
    private String email;
}
