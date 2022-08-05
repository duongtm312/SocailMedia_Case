package com.teamone.socialmediaproject.model.fullpost;

import com.teamone.socialmediaproject.model.AppUser;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPost;
    private String contentPost;
    private String photoPostSrc;
    private long numCommentPost;
    private long numLikePost;
    private Date timePost;
    private String status;
    @ManyToOne
    private AppUser appUser;
}
