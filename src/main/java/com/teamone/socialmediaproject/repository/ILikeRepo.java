package com.teamone.socialmediaproject.repository;

import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.model.fullpost.Likes;
import com.teamone.socialmediaproject.model.fullpost.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILikeRepo extends CrudRepository<Likes, Long> {
 List findByAppUserAndAndPost(AppUser appUser, Post post);
 int countLikesByPost(Post post);

}
