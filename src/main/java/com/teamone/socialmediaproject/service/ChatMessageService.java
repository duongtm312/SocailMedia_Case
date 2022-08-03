package com.teamone.socialmediaproject.service;

import com.teamone.socialmediaproject.model.chat.ChatMessage;
import com.teamone.socialmediaproject.repository.IMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {
    @Autowired
    IMessageRepo iMessageRepo;
    public List<ChatMessage> getAllByIdRoom(long idRoom){
        return iMessageRepo.findAllByRoomChatIdRoom(idRoom);
    }
    public void save(ChatMessage chatMessage){
        iMessageRepo.save(chatMessage);
    }
}
