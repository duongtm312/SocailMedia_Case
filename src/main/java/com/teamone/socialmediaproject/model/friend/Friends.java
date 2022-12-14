package com.teamone.socialmediaproject.model.friend;

import com.teamone.socialmediaproject.model.AppUser;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFriends;
    @ManyToOne
    private AppUser appUser1;
    @ManyToOne
    private AppUser appUser2;
}
