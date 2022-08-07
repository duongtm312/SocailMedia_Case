package com.teamone.socialmediaproject.controller;

import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.model.Profile;
import com.teamone.socialmediaproject.model.dto.CommentsIdPost;
import com.teamone.socialmediaproject.model.friend.AddFriends;
import com.teamone.socialmediaproject.model.fullpost.Comments;
import com.teamone.socialmediaproject.model.fullpost.Post;
import com.teamone.socialmediaproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/home")
public class PostAPI {
    @Autowired
    PostService postService;
    @Autowired
    AppUserService appUserService;
    @Autowired
    ProfileService profileService;
    @Autowired
    AppUserService appUserServicel;
    @Autowired
    CommentServices commentServices;
    @Autowired
    AddFriendService addFriendService;

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

    @PostMapping("/upImg")
    public String upImg(@RequestParam MultipartFile file){
        String name = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),new File("D:\\FE_SocialMedia_Case\\assets\\images\\post\\imgpost" + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/assets/images/post/imgpost/"+name;
    }

    @PostMapping("/createPost")
    public Post save (@RequestBody Post post){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser =appUserServicel.findByName(userDetails.getUsername());
        post.setNumCommentPost(0);
        post.setNumLikePost(0);
        post.setTimePost(new Date());
        post.setAppUser(appUser);
        post.setProfile(profileService.findProfilebyIdUser(appUser.getIdUser()));
        return postService.save(post);
    }

    @GetMapping("/postUser")
    public ResponseEntity<List<Post>> getAllPostByUser() {
        List<Post> list = postService.findAllPostByIdUser(postService.findIdUser());
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }


    @GetMapping("/comment/{idPost}")
    public ResponseEntity<List<Comments>> getComment (@PathVariable long idPost){
        return new ResponseEntity<>(commentServices.findComment(idPost),HttpStatus.OK);
    }

    @GetMapping("/showaddfriend")
    public ResponseEntity<List<AddFriends>> getAddFriend(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long idUser = appUserService.findByName(userDetails.getUsername()).getIdUser();
        List <AddFriends> friendsList = addFriendService.findAllAddFriendById(idUser);
        return new ResponseEntity<>(friendsList,HttpStatus.OK);
    }

    @PostMapping("/createComment")
    public Comments createCmt (@RequestBody CommentsIdPost commentsIdPost){
        if (commentsIdPost.getContent().equals("")) return null;
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser =appUserServicel.findByName(userDetails.getUsername());
        Comments comments = new Comments();
        comments.setPost(postService.findPostById(commentsIdPost.getIdP()));
        comments.setContentCmt(commentsIdPost.getContent());
        comments.setTimeCmt(new Date());
        comments.setNumLikeCmt(0);
        comments.setAppUser(appUser);
        comments.setProfile(profileService.findProfilebyIdUser(appUser.getIdUser()));
        return commentServices.saveCmt(comments);
    }
}
