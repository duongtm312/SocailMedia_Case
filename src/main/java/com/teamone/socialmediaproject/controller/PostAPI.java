package com.teamone.socialmediaproject.controller;

import com.teamone.socialmediaproject.model.fullpost.Post;
import com.teamone.socialmediaproject.service.PostService;
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

    @GetMapping()
    public ResponseEntity<List<Post>> getAllPostFriend() {
        long idUser = postService.findIdUser();
        List <Post> list = postService.findPostByFriend(postService.findIdUser());
        return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
    }

    @GetMapping("/page")
    public ResponseEntity<List<Post>> getAllPostPage() {
        return new ResponseEntity<>(postService.findAllPostByIdUser(postService.findIdUser()), HttpStatus.ACCEPTED);
    }
}
