package com.teamone.socialmediaproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    private String userName;
    private String passWord;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private Set<Role> roles;
    @OneToOne
    private Profile profile;
    public AppUser(String userName, String passWord) {
    }
}
