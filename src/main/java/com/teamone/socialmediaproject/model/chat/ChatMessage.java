package com.teamone.socialmediaproject.model.chat;

import com.teamone.socialmediaproject.model.AppUser;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Timer;

@Entity
@Data
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMessage;
    @ManyToOne
    private AppUser sender;
    @ManyToOne
    private AppUser receiver;
    private String contentMessage;
    private String imgChatSrc;
    @OneToOne
    private RoomChat roomChat;
    private Date time;
}
