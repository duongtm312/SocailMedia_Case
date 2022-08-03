package com.teamone.socialmediaproject.controller.Login;


import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


    @PostMapping("/login")
    public ResponseEntity< String> login(@RequestBody AppUser appUser){
        try {
            // Tạo ra 1 đối tượng Authentication.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(appUser.getUserName(), appUser.getPassWord()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtService.createToken(authentication);
            return new ResponseEntity<>(token,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }
}
