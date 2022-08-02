package com.teamone.socialmediaproject.model.chat;

import com.teamone.socialmediaproject.model.AppUser;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RoomChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRoom;
    @ManyToOne
    private AppUser sender;
    @ManyToOne
    private AppUser receiver;
}
