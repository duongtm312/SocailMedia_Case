package com.teamone.socialmediaproject.controller.Login;


import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.model.Profile;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


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

//    @PostMapping("/register")
//    public void register(@RequestBody AppUser appUser) {
//        appUserService.save(appUser);
//    }

    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody SignUpForm user) {
        if (!user.getPassWord().equals(user.getConfirmPassword())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AppUser user1 = new AppUser(user.getUserName(), user.getPassWord());
        appUserService.save(user1);
        Profile profile = new Profile(
                user.getFullName(),
                user.getPhoneNumber(),
                user.getBirthDay(),
                user.getAddress(),
                user.getStatus(),
                user.getJob(),
                user.getStartJoin(),
                user.getGender(),
                user1
                );
        profileService.save(profile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
