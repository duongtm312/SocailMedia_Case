package com.teamone.socialmediaproject.service;

import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.model.friend.Friends;
import com.teamone.socialmediaproject.repository.IFriendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {
    @Autowired
    IFriendRepo iFriendRepo;
    public Friends save(Friends friends){
        return iFriendRepo.save(friends);
    }
    public Friends saveByAppUser(AppUser appUser1,AppUser appUser2){
        Friends friends = new Friends();
        friends.setAppUser1(appUser1);
        friends.setAppUser2(appUser2);
        iFriendRepo.save(friends);
        Friends friends2 = new Friends();
        friends2.setAppUser1(appUser2);
        friends2.setAppUser2(appUser1);
        return iFriendRepo.save(friends2);
    }
}
