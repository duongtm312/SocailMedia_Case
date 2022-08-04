package com.teamone.socialmediaproject.service;


import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.repository.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    IAppUserRepo iAppUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iAppUserRepo.findByUserName(username);
        return new User(appUser.getUserName(), appUser.getPassWord(), appUser.getRoles());
    }

    public List<AppUser> getAll(){
        return (List<AppUser>) iAppUserRepo.findAll();
    }
    public AppUser findByName(String name) {
        return  iAppUserRepo.findByUserName(name);
    }

    public void save(AppUser appUser){
        iAppUserRepo.save(appUser);
    }
    public AppUser findByEMail(String email){
        return iAppUserRepo.findByEmail(email);
    }

    public Optional<AppUser> findByID(Long id){
        return iAppUserRepo.findById(id);
    }
}
