package com.teamone.socialmediaproject.controller;

import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.model.Profile;
import com.teamone.socialmediaproject.service.AppUserService;
import com.teamone.socialmediaproject.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/profiles")
public class ProfileAPI {
    @Autowired
    ProfileService profileService;
    @Autowired
    AppUserService appUserService;


    @PostMapping
    public void save(@RequestBody Profile profile) {
        profileService.save(profile);
    }

    @GetMapping("/profile")
    public Profile findById() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByName(userDetails.getUsername());
        return profileService.findByName(appUser.getUserName());


    }

    @PostMapping("/edit")
    public void edit(@RequestBody Profile profile) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByName(userDetails.getUsername());
      Profile proOld =  profileService.findByName(appUser.getUserName());
        profile.setAppUser(appUser);
        profile.setAvatarSrc(proOld.getAvatarSrc());
        profile.setPhotoCoverSrc(proOld.getPhotoCoverSrc());
        profileService.save(profile);
    }

}

