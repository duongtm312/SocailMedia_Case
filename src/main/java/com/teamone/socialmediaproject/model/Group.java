package com.teamone.socialmediaproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idGroup;
    private String nameGroup;
    private String describe;
    @ManyToOne
    private AppUser admin;
    private String avatarGroup;
    private String photoCoverGroup;
    private long numMember;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUser> members;
}
