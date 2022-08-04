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
    public void save(Profile profile) {
        iUserProfileRepo.save(profile);
    }
    public List<Profile> getAll(long user){
        return iUserProfileRepo.getAllProfileFriends(user);
    }
}
