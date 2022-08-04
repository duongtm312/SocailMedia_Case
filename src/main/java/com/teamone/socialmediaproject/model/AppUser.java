package com.teamone.socialmediaproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    private String userName;
    private String passWord;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
