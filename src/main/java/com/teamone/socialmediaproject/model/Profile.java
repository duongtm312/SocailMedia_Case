package com.teamone.socialmediaproject.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProfile;
    private String fullName;
    private String phoneNumber;
    private Date birthDay;
    private String address;
    private String status;
    private String job;
    private String avatarSrc;
    private String photoCoverSrc;
        private Date startJoin;
    private String gender;
    @OneToOne
    private AppUser appUser;
}
