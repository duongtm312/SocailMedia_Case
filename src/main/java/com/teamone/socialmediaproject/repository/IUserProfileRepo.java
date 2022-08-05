package com.teamone.socialmediaproject.repository;

import com.teamone.socialmediaproject.model.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserProfileRepo extends CrudRepository<Profile, Long> {
    @Query(nativeQuery = true, value = "select * from profile where app_user_id_user = ?" )
    Profile findByUserId(Long id);
    Profile findByAppUserUserName(String name);
    @Query(nativeQuery = true, value = "select app_user_id_user from profile where id_profile=?")
    Long findUserByProfile(Long id);
    @Query(nativeQuery = true,value = "SELECT * FROM social_media.friends S join profile P on S.app_user2_id_user = P.app_user_id_user where S.app_user1_id_user=:user ;")
    List<Profile> getAllProfileFriends(@Param("user") long user);

    Profile findProfileByAppUserIdUser (long id);
    @Query(nativeQuery = true,value = "SELECT * FROM profile where app_user_id_user not in (SELECT app_user2_id_user FROM social_media.friends  where app_user1_id_user = :user) and full_name like concat ('%',:name,'%');")
    List<Profile>findAllByProfileNotFriends(@Param("user") long user ,@Param("name") String name);
}
