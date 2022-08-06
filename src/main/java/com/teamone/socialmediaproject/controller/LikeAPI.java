package com.teamone.socialmediaproject.controller;

import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.model.fullpost.Likes;
import com.teamone.socialmediaproject.service.AppUserService;
import com.teamone.socialmediaproject.service.LikeService;
import com.teamone.socialmediaproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/like")
public class LikeAPI {
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PostService postService;

    @Autowired
    LikeService likeService;


@PostMapping
    public void likeObject(@RequestBody Likes likes) {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    AppUser appUser = appUserService.findByName(userDetails.getUsername());
    likes.setAppUser(appUser);
    likeService.check(likes);
}

}
