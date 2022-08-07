package com.teamone.socialmediaproject.repository;

import com.teamone.socialmediaproject.model.friend.Friends;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFriendRepo extends CrudRepository<Friends,Long> {
}
