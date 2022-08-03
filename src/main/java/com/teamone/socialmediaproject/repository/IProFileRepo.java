package com.teamone.socialmediaproject.repository;

import com.teamone.socialmediaproject.model.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProFileRepo extends CrudRepository<Profile,Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM social_media.friends S join profile P on S.app_user2_id_user = P.app_user_id_user where S.app_user1_id_user=:user ;")
    List<Profile> getAllProfileFriends(@Param("user") String user);
}
