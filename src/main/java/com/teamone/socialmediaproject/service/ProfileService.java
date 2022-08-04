package com.teamone.socialmediaproject.service;

import com.teamone.socialmediaproject.model.Profile;
import com.teamone.socialmediaproject.repository.IProFileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfileService {
    @Autowired
    IProFileRepo iProFileRepo;
    public List<Profile> getAll(long user){
        return iProFileRepo.getAllProfileFriends(user);
    }
}
