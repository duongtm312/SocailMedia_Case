package com.teamone.socialmediaproject.repository;

import com.teamone.socialmediaproject.model.fullpost.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPostRepo extends CrudRepository<Post,Long> {
    @Query(nativeQuery = true, value = "select * from post p join friends f on p.app_user_id_user = f.app_user1_id_user where p.app_user_id_user = :idUser;")
    List<Post> findAllPostByFriend(@Param("idUser") long idUser);

    List <Post> findAllByAppUser_IdUser();

}
