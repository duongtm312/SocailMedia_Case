package com.teamone.socialmediaproject.service;


import com.teamone.socialmediaproject.model.AppUser;
import com.teamone.socialmediaproject.model.dto.DataMailDTO;
import com.teamone.socialmediaproject.repository.IAppUserRepo;
import com.teamone.socialmediaproject.service.sdi.ClientSdi;
import com.teamone.socialmediaproject.utils.Const;
import com.teamone.socialmediaproject.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    MailService mailService;
    @Autowired
    IAppUserRepo iAppUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iAppUserRepo.findByUserName(username);
        return new User(appUser.getUserName(), appUser.getPassWord(), appUser.getRoles());
    }

    public List<AppUser> getAll(){
        return (List<AppUser>) iAppUserRepo.findAll();
    }
    public AppUser findByName(String name) {
        return  iAppUserRepo.findByUserName(name);
    }

    public AppUser save(AppUser appUser) {
            try {
                DataMailDTO dataMail = new DataMailDTO();

                dataMail.setTo(appUser.getEmail());
                dataMail.setSubject(Const.SEND_MAIL_SUBJECT.CLIENT_REGISTER);

                Map<String, Object> props = new HashMap<>();
                props.put("username", appUser.getUserName());
                dataMail.setProps(props);

                mailService.sendHtmlMail(dataMail, Const.TEMPLATE_FILE_NAME.CLIENT_REGISTER);
            } catch (MessagingException exp){
                exp.printStackTrace();
            }
        return iAppUserRepo.save(appUser);
    }
    public AppUser findByEMail(String email){
        return iAppUserRepo.findByEmail(email);
    }
    public Optional<AppUser> findById(long id){
        return iAppUserRepo.findById(id);
    }
}
