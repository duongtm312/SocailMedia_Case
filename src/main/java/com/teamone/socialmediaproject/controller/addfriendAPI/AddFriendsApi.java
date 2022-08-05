package com.teamone.socialmediaproject.controller.addfriendAPI;

import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.model.friend.AddFriends;
import com.teamone.socialmediaproject.service.AddFriendService;
import com.teamone.socialmediaproject.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/addFriend")
public class AddFriendsApi {
    @Autowired
    AppUserService appUserService;
    @Autowired
    AddFriendService addFriendService;

    @GetMapping
    public AddFriends addFriend(@RequestParam String user) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByName(userDetails.getUsername());
        AppUser appUser1 = appUserService.findByName(user);
        AddFriends addFriends = new AddFriends();
        addFriends.setAppUser1(appUser);
        addFriends.setAppUser2(appUser1);
        if (addFriendService.findByAppUser1_UserNameAndAndAppUser2_UserName(appUser.getUserName(), appUser1.getUserName()) == null) {
           return addFriendService.save(addFriends);
        }else {
            return new AddFriends();
        }
    }
}
