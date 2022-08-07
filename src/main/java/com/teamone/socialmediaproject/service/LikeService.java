package com.teamone.socialmediaproject.service;


import com.teamone.socialmediaproject.model.fullpost.Likes;
import com.teamone.socialmediaproject.repository.ILikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LikeService {
    @Autowired
    ILikeRepo iLikeRepo;

 @Autowired
    PostService postService;

// public void save(Likes like) {
//     iLikeRepo.save(like);
// }
 public void check(Likes likes) {
     Likes likes1 =  iLikeRepo.findByAppUserAndAndPost(likes.getAppUser(), postService.findPostById(likes.getPost().getIdPost()));

     if (likes1 == null) {
         iLikeRepo.save(likes);
     }else {
         iLikeRepo.delete(likes1);
     }
 }

 public void remove (Likes likes) {
     iLikeRepo.delete(likes);
 }
}
