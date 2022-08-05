package com.teamone.socialmediaproject.controller.searchAPI;

import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.model.Profile;
import com.teamone.socialmediaproject.service.AppUserService;
import com.teamone.socialmediaproject.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@CrossOrigin("*")
public class SearchAPI {
    @Autowired
    ProfileService profileService;
    @Autowired
    AppUserService appUserService;
    @GetMapping
    public List<Profile>getAll(@RequestParam String name){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByName(userDetails.getUsername());
        Profile profile = profileService.findProfilebyIdUser(appUser.getIdUser());
        List<Profile> list=profileService.findAllByProfileNotFriends(appUser.getIdUser(),name);
        list.remove(profile);
        return list;
    }
}
