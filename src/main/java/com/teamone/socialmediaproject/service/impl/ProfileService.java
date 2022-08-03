package com.teamone.socialmediaproject.service.impl;

import com.teamone.socialmediaproject.model.Profile;
import com.teamone.socialmediaproject.repository.IProfileRepo;
import com.teamone.socialmediaproject.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfileService implements IProfileService {
    @Autowired
    IProfileRepo iProfileRepo;

    @Override
    public List<Profile> getAll() {
        return (List<Profile>) iProfileRepo.findAll();
    }

    @Override
    public Profile save(Profile profile) {
        return iProfileRepo.save(profile);
    }

    @Override
    public Profile findById(long id) {
return iProfileRepo.findById(id).get();
    }
}
