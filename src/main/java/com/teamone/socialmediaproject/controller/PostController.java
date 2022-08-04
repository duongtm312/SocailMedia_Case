package com.teamone.socialmediaproject.controller;

import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.model.fullpost.Post;
import com.teamone.socialmediaproject.service.AppUserService;
import com.teamone.socialmediaproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    AppUserService appUserService;
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    long idUser = appUserService.findByName(userDetails.getUsername()).getIdUser();

    @GetMapping()
    public ResponseEntity<List<Post>> getAllPostFriend() {
        return new ResponseEntity<>(postService.findPostByFriend(appUserService.findByName(userDetails.getUsername()).getIdUser()),HttpStatus.ACCEPTED);
    }
    @GetMapping("/page")
    public ResponseEntity<List<Post>> getAllPostPage(){
        return new ResponseEntity<>(postService.findAllPostByIdUser(),HttpStatus.ACCEPTED);
    }
}
