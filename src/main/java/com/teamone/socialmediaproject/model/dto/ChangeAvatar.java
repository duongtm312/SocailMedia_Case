package com.teamone.socialmediaproject.model.dto;

public class ChangeAvatar {
    private String avatar;

    public ChangeAvatar(String namImg) {

        this.avatar = namImg;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
