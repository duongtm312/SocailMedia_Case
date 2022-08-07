package com.teamone.socialmediaproject.service;

import com.teamone.socialmediaproject.model.fullpost.Comments;
import com.teamone.socialmediaproject.repository.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class CommentServices {
    @Autowired
    ICommentRepo iCommentRepo;
    public List<Comments> findComment(long idPost) {
        return iCommentRepo.findAllByPostIdPost(idPost);
    }

    public Comments saveCmt (Comments comments){
        return iCommentRepo.save(comments);
    }
}
