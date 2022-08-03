package com.teamone.socialmediaproject.service;

import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.repository.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    @Autowired
    IAppUserRepo iAppUserRepo;
    public AppUser findByName(String name){
        return iAppUserRepo.findByUserName(name);
    }
}
