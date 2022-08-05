package com.teamone.socialmediaproject.repository;

import com.teamone.socialmediaproject.model.fullpost.Likes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILikePost extends CrudRepository<Likes, Long> {
    List<Likes> findAllByAppUserIdUser(Long id);
    List<Likes> findAllByAppUserIdUserAndAndPost(Long idUser, Long idPost);

}
