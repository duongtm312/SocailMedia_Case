package com.teamone.socialmediaproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public Profile(String fullName, String phoneNumber, Date birthDay, String address, String status, String job, Date startJoin, String gender, AppUser appUser) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.address = address;
        this.status = status;
        this.job = job;
        this.startJoin = startJoin;
        this.gender = gender;
        this.appUser = appUser;
}

}
