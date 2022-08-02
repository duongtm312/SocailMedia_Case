package com.teamone.socialmediaproject.controller.socketcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin("*")
public class ChatController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
}
