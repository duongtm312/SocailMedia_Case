package com.teamone.socialmediaproject.controller.addfriendAPI;

import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.model.friend.AddFriends;
import com.teamone.socialmediaproject.model.friend.Friends;
import com.teamone.socialmediaproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AddFriendsApi {
    @Autowired
    AppUserService appUserService;
    @Autowired
    ProfileService profileService;
    @Autowired
    PostService postService;
    @Autowired
    AddFriendService addFriendService;
    @Autowired
    FriendService friendService;

    @GetMapping("/addFriend")
    public AddFriends addFriend(@RequestParam String user) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByName(userDetails.getUsername());
        AppUser appUser1 = appUserService.findByName(user);
        AddFriends addFriends = new AddFriends();
        addFriends.setAppUser1(appUser);
        addFriends.setAppUser2(appUser1);
        addFriends.setProfile(profileService.findProfilebyIdUser(appUser1.getIdUser()));
        if (addFriendService.findByAppUser1_UserNameAndAndAppUser2_UserName(appUser.getUserName(), appUser1.getUserName()) == null) {
           return addFriendService.save(addFriends);
        }else {
            return new AddFriends();
        }
    }
    @GetMapping("/acceptFriend")
    public Friends acceptFriend(@RequestParam String user) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByName(userDetails.getUsername());
        AppUser appUser1 = appUserService.findByName(user);
        addFriendService.delete(appUser,appUser1);
        return friendService.saveByAppUser(appUser,appUser1);
    }

    @GetMapping("/deleteAdd")
    public AddFriends deleteAdd(@RequestParam String user) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByName(userDetails.getUsername());
        AppUser appUser1 = appUserService.findByName(user);

       return addFriendService.delete(appUser,appUser1);

    }

}
