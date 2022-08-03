package com.teamone.socialmediaproject.controller.socketcontroller;

import com.teamone.socialmediaproject.model.chat.ChatMessage;
import com.teamone.socialmediaproject.service.ChatMessageService;
import com.teamone.socialmediaproject.service.RoomChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin("*")
public class RestChatController {
    @Autowired
    RoomChatService roomChatService;
    @Autowired
    ChatMessageService chatMessageService;
    @GetMapping("/room")
    public long room( @RequestBody String receiver){
        String sender="";
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        sender=userDetails.getUsername();
       long idRoom = roomChatService.getIdRoomChat(sender,receiver);
       if (idRoom!=-1){
        return idRoom;
       }else {
           return roomChatService.save(sender,receiver).getIdRoom();
       }
    }
    @GetMapping
    public List<ChatMessage> getAll( @RequestBody long idRoom){
       return chatMessageService.getAllByIdRoom(idRoom);

    }
}
