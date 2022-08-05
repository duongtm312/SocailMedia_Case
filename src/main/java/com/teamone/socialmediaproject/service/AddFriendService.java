package com.teamone.socialmediaproject.service;

import com.teamone.socialmediaproject.controller.addfriendAPI.AddFriendsApi;
import com.teamone.socialmediaproject.model.friend.AddFriends;
import com.teamone.socialmediaproject.repository.IAddFriendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddFriendService {
    @Autowired
    IAddFriendRepo iAddFriendRepo;
    public AddFriends save(AddFriends addFriends){
      return iAddFriendRepo.save(addFriends);
    }
    public void delete(long id){
        iAddFriendRepo.deleteById(id);
    }
    public AddFriends findById(long id){
        return iAddFriendRepo.findById(id).get();
    }
    public AddFriends findByAppUser1_UserNameAndAndAppUser2_UserName(String user1,String user2){
        return iAddFriendRepo.findByAppUser1_UserNameAndAndAppUser2_UserName(user1,user2);
    }
}
