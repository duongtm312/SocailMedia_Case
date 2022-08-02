package com.teamone.socialmediaproject.repository;

import com.teamone.socialmediaproject.model.chat.ChatMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IMessageRepo extends CrudRepository<ChatMessage,Long> {
    List<ChatMessage> findAllByRoomChatIdRoom(long idRoom);
}
