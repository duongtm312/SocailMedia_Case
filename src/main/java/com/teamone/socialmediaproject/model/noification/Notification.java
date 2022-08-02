package com.teamone.socialmediaproject.model.noification;

import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.model.fullpost.Post;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNT;
    @ManyToOne
    private AppUser userSend;
    @ManyToOne
    private AppUser userReceive;
    @ManyToOne
    private Post post;
    private String contentNT;
}
