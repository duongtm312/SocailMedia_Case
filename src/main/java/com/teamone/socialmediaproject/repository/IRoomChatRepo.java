package com.teamone.socialmediaproject.repository;

import com.teamone.socialmediaproject.model.chat.RoomChat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomChatRepo extends CrudRepository<RoomChat,Long> {
    RoomChat findBySenderUserNameAndReceiverUserName(String sender,String receiver);
}
