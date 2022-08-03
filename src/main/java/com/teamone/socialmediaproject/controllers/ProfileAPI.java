package com.teamone.socialmediaproject.controllers;

import com.teamone.socialmediaproject.model.Profile;
import com.teamone.socialmediaproject.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/profiles")
public class ProfileAPI {
    @Autowired
   IProfileService profileService;
@PutMapping
    public Profile edit (@RequestBody Profile profile){
    return profileService.save(profile);
}

}
