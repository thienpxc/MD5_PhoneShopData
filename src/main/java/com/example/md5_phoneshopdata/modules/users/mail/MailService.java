package com.example.md5_phoneshopdata.modules.users.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    public JavaMailSender emailSender;
    public void sendMail(Option option) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("projectmodules5@gmail.com");

        String[] toArray = new String[option.getTo().size()];
        option.getTo().toArray(toArray);
        message.setTo(toArray);

        message.setSubject(option.getSubject());
        message.setText(option.getText());
        emailSender.send(message);
    }


}
