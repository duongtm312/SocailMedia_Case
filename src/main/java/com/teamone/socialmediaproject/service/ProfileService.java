package com.teamone.socialmediaproject.service;

import com.teamone.socialmediaproject.model.Profile;
import com.teamone.socialmediaproject.repository.IProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService  {
    @Autowired
    IProfileRepo iProfileRepo;
    public List<Profile>getAll(){
       return (List<Profile>) iProfileRepo.findAll();

    }
    public Profile save(Profile profile){
        return iProfileRepo.save(profile);
    }
    public Profile findById(long id){
        return iProfileRepo.findById(id).get();
    }
}
