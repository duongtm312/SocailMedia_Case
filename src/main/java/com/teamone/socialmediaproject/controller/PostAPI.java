package com.teamone.socialmediaproject.controller;

import com.teamone.socialmediaproject.model.Profile;
import com.teamone.socialmediaproject.model.fullpost.Post;
import com.teamone.socialmediaproject.service.AppUserService;
import com.teamone.socialmediaproject.service.PostService;
import com.teamone.socialmediaproject.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/home")
public class PostAPI {
    @Autowired
    PostService postService;
    @Autowired
    ProfileService profileService;

    @GetMapping("/post")
    public ResponseEntity<List<Post>> getAllPostFriend() {
        List <Post> list = postService.findPostByFriend(postService.findIdUser());
        return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
    }

    @GetMapping("/page")
    public ResponseEntity<List<Post>> getAllPostPage() {
        return new ResponseEntity<>(postService.findAllPostByIdUser(postService.findIdUser()), HttpStatus.ACCEPTED);
    }

    @GetMapping("/profile")
    public ResponseEntity<Profile> getProfile(){
        return new ResponseEntity<>(profileService.findProfilebyIdUser(postService.findIdUser()),HttpStatus.ACCEPTED);
    }

}
