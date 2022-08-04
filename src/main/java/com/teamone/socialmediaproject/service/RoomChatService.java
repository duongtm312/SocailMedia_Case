package com.teamone.socialmediaproject.service;

import com.teamone.socialmediaproject.model.chat.RoomChat;
import com.teamone.socialmediaproject.repository.IRoomChatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomChatService {
    @Autowired
    IRoomChatRepo iRoomChatRepo;
    @Autowired
    AppUserService appUserService;

    public long getIdRoomChat(String sen, String re) {
        RoomChat roomChat = iRoomChatRepo.findBySenderUserNameAndReceiverUserName(sen, re);
        RoomChat roomChat2 = iRoomChatRepo.findBySenderUserNameAndReceiverUserName(re, sen);
        if (roomChat != null) {
            return roomChat.getIdRoom();
        } else if (roomChat2!=null){
            return roomChat2.getIdRoom();
        }else {
            return -1;
        }
    }

    public RoomChat save(String sen, String re) {
        RoomChat roomChat = new RoomChat();
        roomChat.setSender(appUserService.findByName(re));
        roomChat.setReceiver(appUserService.findByName(sen));
        return iRoomChatRepo.save(roomChat);
    }
}
