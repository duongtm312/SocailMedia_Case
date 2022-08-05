package com.teamone.socialmediaproject.controller.socketcontroller;

import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.model.chat.ChatMessage;
import com.teamone.socialmediaproject.service.AppUserService;
import com.teamone.socialmediaproject.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

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
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByName(userDetails.getUsername());
        messageChat.setSender(appUser);
        chatMessageService.save(messageChat);
        simpMessagingTemplate.convertAndSend("/chatroom/public/"+ messageChat.getRoomChat().getIdRoom(), messageChat);

    }
}
