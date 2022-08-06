package com.teamone.socialmediaproject.service;


import com.teamone.socialmediaproject.model.dto.DataMailDTO;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

public interface MailService {
    void sendHtmlMail(DataMailDTO dataMail, String templateName) throws MessagingException;
}
