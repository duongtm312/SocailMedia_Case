package com.teamone.socialmediaproject.service;

import com.teamone.socialmediaproject.model.fullpost.Post;
import com.teamone.socialmediaproject.repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService {
    @Autowired
    IPostRepo iPostRepo;

    public Post save (Post post){
        return iPostRepo.save(post);
    }
    public void delete (long idPost) {
        iPostRepo.deleteById(idPost);
    }

    public Post findPostById (long idPost){
        return iPostRepo.findById(idPost).get();
    }
    public List<Post> findPostByFriend (long idUser){
        return iPostRepo.findAllPostByFriend(idUser);
    }

    public List <Post> findAllPostByIdUser (){
        return iPostRepo.findAllByAppUser_IdUser();
    }



}
