package com.teamone.socialmediaproject.repository;

import com.teamone.socialmediaproject.model.fullpost.Post;
import org.springframework.data.repository.CrudRepository;

public interface IPostRepo extends CrudRepository<Post,Long> {
}
