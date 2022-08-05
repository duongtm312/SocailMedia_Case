package com.teamone.socialmediaproject.controller.Login;


import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.model.Profile;
import com.teamone.socialmediaproject.model.Role;
import com.teamone.socialmediaproject.model.dto.ChangePassword;
import com.teamone.socialmediaproject.model.dto.SignUpForm;
import com.teamone.socialmediaproject.service.AppUserService;
import com.teamone.socialmediaproject.service.JwtService;
import com.teamone.socialmediaproject.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@RestController
@CrossOrigin("*")
public class LoginAPI {
    @Autowired
    JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    AppUserService appUserService;

    @Autowired
    ProfileService profileService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AppUser appUser) {
        try {
            // Tạo ra 1 đối tượng Authentication.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(appUser.getUserName(), appUser.getPassWord()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtService.createToken(authentication);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }


    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody SignUpForm user) {
        if (!user.getPassWord().equals(user.getConfirmPassword()) || appUserService.findByName(user.getUserName()) != null
                || appUserService.findByEMail(user.getEmail()) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AppUser user1 = new AppUser();
        user1.setUserName(user.getUserName());
        user1.setPassWord(user.getPassWord());
        user1.setEmail(user.getEmail());
        Set<Role> roleSet = new HashSet<>();
        Role role = new Role();
        role.setNameRole("ROLE_USER");
        roleSet.add(role);
        user1.setRoles(roleSet);
        appUserService.save(user1);
        Profile profile = new Profile(
        );
        profile.setFullName(user.getFullName());
        profile.setAppUser(user1);
        profileService.save(profile);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @PostMapping("/changePassword")
    public ResponseEntity<AppUser> changePassword(@RequestBody ChangePassword changePassword) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByName(userDetails.getUsername());
        String newPassword;
        String oldPassword = changePassword.getOldPassword();
        if (oldPassword.equals(appUser.getPassWord())) {
            if (changePassword.getNewPassword().equals(changePassword.getConfirmNewPassword())) {
                newPassword = changePassword.getNewPassword();
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        appUser.setPassWord(newPassword);
        appUserService.save(appUser);
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }

}




