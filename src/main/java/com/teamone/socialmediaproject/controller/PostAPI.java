package com.teamone.socialmediaproject.controller;

import com.teamone.socialmediaproject.model.Profile;
import com.teamone.socialmediaproject.model.fullpost.Post;
import com.teamone.socialmediaproject.service.AppUserService;
import com.teamone.socialmediaproject.service.PostService;
import com.teamone.socialmediaproject.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

//    ________________________________________________________
@PostMapping
public void upAvatar(@RequestBody Profile profile) {
         profileService.save(profile);
}
@PostMapping("/upImg")
        public String upImg(@RequestParam MultipartFile file) {
    String name = file.getOriginalFilename();
    try {
        FileCopyUtils.copy(file.getBytes(),new File("C:\\Users\\phamv\\Downloads\\Font_End\\FE_SocialMedia_Case\\assets\\images\\"));

    } catch (IOException e) {
        e.printStackTrace();
    }
    return "/img/" + name;
}

}
