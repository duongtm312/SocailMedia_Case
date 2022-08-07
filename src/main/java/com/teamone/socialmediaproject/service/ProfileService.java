package com.teamone.socialmediaproject.service;

import com.teamone.socialmediaproject.model.Profile;
import com.teamone.socialmediaproject.repository.IUserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    IUserProfileRepo iUserProfileRepo;
    public Profile save(Profile profile) {
        iUserProfileRepo.save(profile);
        return profile;
    }
    public List<Profile> getAll(long user){
        return iUserProfileRepo.getAllProfileFriends(user);
    }

    public Profile findProfilebyIdUser (long id){
        return iUserProfileRepo.findProfileByAppUserIdUser(id);
    }
public Profile findByName(String name){
        return iUserProfileRepo.findByAppUserUserName(name);
}
    public List<Profile>findAllByProfileNotFriends(long user,String name){
        return iUserProfileRepo.findAllByProfileNotFriends(user,name);
    }
}
