package com.teamone.socialmediaproject.service;


import com.teamone.socialmediaproject.model.fullpost.Likes;
import com.teamone.socialmediaproject.model.fullpost.Post;
import com.teamone.socialmediaproject.repository.ILikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LikeService {
    @Autowired
    ILikeRepo iLikeRepo;

 @Autowired
    PostService postService;

 public void save(Likes like) {
     iLikeRepo.save(like);
 }
 public void check(Likes likes) {
     Likes likes1 = (Likes) iLikeRepo.findByAppUserAndAndPost(likes.getAppUser(), postService.findPostById(likes.getPost().getIdPost()));

     if (likes1 == null) {
         save(likes);
     }else {
         remove(likes1);
     }
 }

 public void remove (Likes likes) {
     iLikeRepo.delete(likes);
 }
 public int countByPost(Post post){
     return iLikeRepo.countLikesByPost(post);
 }
}
