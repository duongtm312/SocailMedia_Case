package com.teamone.socialmediaproject.controller;

import com.teamone.socialmediaproject.model.fullpost.Post;
import com.teamone.socialmediaproject.service.AppUserService;
import com.teamone.socialmediaproject.service.LikeService;
import com.teamone.socialmediaproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/user")
public class LikePostController {
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PostService postService;

    @Autowired
    LikeService likeService;





}
