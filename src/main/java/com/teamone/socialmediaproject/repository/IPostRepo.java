package com.teamone.socialmediaproject.repository;

import com.teamone.socialmediaproject.model.fullpost.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IPostRepo extends CrudRepository<Post,Long> {

    @Query(nativeQuery = true, value = "select * from post p join friends f on p.app_user_id_user = f.app_user2_id_user where f.app_user1_id_user = :idUser order by time_post desc ")
    List<Post> findAllPostByFriend(@Param("idUser") long idUser);

    @Query(nativeQuery = true,value = "select * from post where app_user_id_user =:idUser order by time_post desc")
    List <Post> findAllPostById(@Param("idUser") long idUser);



}
