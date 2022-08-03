package com.teamone.socialmediaproject.service;

import com.teamone.socialmediaproject.model.Profile;

import java.util.List;

public interface IProfileService {
    List<Profile> getAll();
   Profile save(Profile profile);
    Profile findById(long id);

}
