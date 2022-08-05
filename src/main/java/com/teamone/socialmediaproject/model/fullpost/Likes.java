package com.teamone.socialmediaproject.model.fullpost;

import com.teamone.socialmediaproject.model.AppUser;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLikes;
    @ManyToOne
    private Post post;
    @ManyToOne
    private AppUser appUser;
    @ManyToOne
    private Comments comments;
    private Date timeLike;
    private boolean isLiked;
}

