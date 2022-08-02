package com.teamone.socialmediaproject.model.fullpost;

import com.teamone.socialmediaproject.model.AppUser;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idComment;
    public String contentCmt;
    private long numLikeCmt;
    @ManyToOne
    private AppUser appUser;
    @ManyToOne
    private Post post;
    @ManyToOne
    private Comments comment;
}
