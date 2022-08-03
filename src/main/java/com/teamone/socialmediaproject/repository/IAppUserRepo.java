package com.teamone.socialmediaproject.repository;

import com.teamone.socialmediaproject.model.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepo extends CrudRepository<AppUser, Long> {
    @Query(nativeQuery = true, value = "select * from app_user where user_name like concat ('%',:name,'%');")
    AppUser findByUserName(@Param("name") String name);
}
