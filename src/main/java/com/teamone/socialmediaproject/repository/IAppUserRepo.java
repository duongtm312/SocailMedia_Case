package com.teamone.socialmediaproject.repository;


import com.teamone.socialmediaproject.model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface IAppUserRepo extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}