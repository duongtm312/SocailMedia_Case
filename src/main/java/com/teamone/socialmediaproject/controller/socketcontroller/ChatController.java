package com.teamone.socialmediaproject.controller.socketcontroller;

import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.model.chat.ChatMessage;
import com.teamone.socialmediaproject.service.AppUserService;
import com.teamone.socialmediaproject.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;

@Controller
@CrossOrigin("*")
public class ChatController {
    @Autowired
    AppUserService appUserService;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    ChatMessageService chatMessageService;
    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessage messageChat) {
        AppUser appUser = appUserService.findByName(messageChat.getReceiver().getUserName());
        messageChat.setReceiver(appUser);
        Date date=new Date();
        messageChat.setTime(date);
        chatMessageService.save(messageChat);
        simpMessagingTemplate.convertAndSend("/chatroom/public/"+ messageChat.getRoomChat().getIdRoom(), messageChat);

    }
}
