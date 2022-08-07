package com.teamone.socialmediaproject.repository;

import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.model.friend.AddFriends;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAddFriendRepo extends CrudRepository<AddFriends, Long> {
    AddFriends findByAppUser1_UserNameAndAndAppUser2_UserName(String user1, String user2);


    @Query(nativeQuery = true, value = "SELECT * FROM social_media.add_friends where app_user2_id_user = :idUser")
    List<AddFriends> findAllByAppUser1(@Param("idUser") long idUser);
}
