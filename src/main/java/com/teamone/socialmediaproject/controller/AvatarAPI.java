package com.teamone.socialmediaproject.controller;

import com.teamone.socialmediaproject.model.Profile;

import com.teamone.socialmediaproject.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
@CrossOrigin("*")
    @RequestMapping("/homes")
public class AvatarAPI {
    @Autowired
    ProfileService profileService;


    @PostMapping("/setchange")
    public Profile save(@RequestBody Profile profile) {
        return profileService.save(profile);
    }

    @PostMapping("/upImg")
    public String upImg(@RequestParam MultipartFile file) {
        String name = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File("C:\\Users\\phamv\\Downloads\\Font_End\\FE_SocialMedia_Case\\assets\\images\\" + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "\\assets\\images\\" + name;
    }


}