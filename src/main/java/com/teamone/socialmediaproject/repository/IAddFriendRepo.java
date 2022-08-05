package com.teamone.socialmediaproject.repository;
import com.teamone.socialmediaproject.model.friend.AddFriends;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddFriendRepo extends CrudRepository<AddFriends,Long> {
AddFriends findByAppUser1_UserNameAndAndAppUser2_UserName(String user1, String user2);
}
