package com.teamone.socialmediaproject.service;

import com.teamone.socialmediaproject.model.fullpost.Likes;
import com.teamone.socialmediaproject.repository.ILikePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    ILikePost iLikePost;

    public Likes findAll() {
      return (Likes) iLikePost.findAll();
    }

    public Likes save(Likes likesPost) {
        return iLikePost.save(likesPost);
    }
    public Optional<Likes> findById (Long id) {
        return iLikePost.findById(id);
    }

    public void remove (Long id) {
        iLikePost.deleteById(id);
    }

    public Likes findAllByIdUser(Long id) {
        return (Likes) iLikePost.findAllByAppUserIdUser(id);
    }
    public Likes findByAppUserIdUser(Long idUser, Long idPost) {
        return (Likes) iLikePost.findAllByAppUserIdUserAndAndPost(idUser,idPost);
    }
}
