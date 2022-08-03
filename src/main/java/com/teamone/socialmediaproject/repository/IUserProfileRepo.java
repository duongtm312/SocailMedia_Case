package com.teamone.socialmediaproject.repository;

import com.teamone.socialmediaproject.model.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserProfileRepo extends CrudRepository<Profile, Long> {
    @Query(nativeQuery = true, value = "select * from profile where app_user_id_user = ?" )
    Profile findByUserId(Long id);

    @Query(nativeQuery = true, value = "select app_user_id_user from profile where id_profile=?")
    Long findUserByProfile(Long id);
}
