package com.teamone.socialmediaproject.repository;

import com.teamone.socialmediaproject.model.fullpost.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepo extends CrudRepository<Comments,Long> {

    List<Comments> findAllByPostIdPost (long idPost);
    }

