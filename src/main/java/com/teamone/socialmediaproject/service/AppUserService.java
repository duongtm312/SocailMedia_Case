package com.teamone.socialmediaproject.service;


;
import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.repository.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    IAppUserRepo iAppUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iAppUserRepo.findByUsername(username);
        return new User(appUser.getUserName(), appUser.getPassWord(), );
    }

    public List<AppUser> getAll(){
        return (List<AppUser>) iAppUserRepo.findAll();
    }
}
