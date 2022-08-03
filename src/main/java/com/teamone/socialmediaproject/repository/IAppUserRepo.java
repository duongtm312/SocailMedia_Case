package com.teamone.socialmediaproject.repository;

import com.teamone.socialmediaproject.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepo extends CrudRepository<AppUser,Long> {
    AppUser findByUserName(String userName);
}
