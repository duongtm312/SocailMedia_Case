package com.teamone.socialmediaproject.controllers;

import com.teamone.socialmediaproject.model.Profile;
import com.teamone.socialmediaproject.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/profiles")
public class ProfileAPI {
    @Autowired
    ProfileService profileService;

    @GetMapping
    public List<Profile> getAll() {
        return profileService.getAll();
    }

    @PostMapping
    public Profile save(@RequestBody Profile profile) {
        return profileService.save(profile);
    }

    @GetMapping("/{id}")
    public Profile findById(@PathVariable long id) {
        return profileService.findById(id);

    } @PutMapping
    public Profile edit(@RequestBody Profile profile){
        return profileService.save(profile);
    }

}

