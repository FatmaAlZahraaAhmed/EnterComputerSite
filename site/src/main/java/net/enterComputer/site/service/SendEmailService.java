package net.enterComputer.site.service;

import net.enterComputer.site.model.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(Subscriber subscriber) {
        System.out.println("message sending......");
        SimpleMailMessage newMessage = new SimpleMailMessage();
        newMessage.setTo(subscriber.getEmail());
        newMessage.setFrom("totanoni25@gmail.com");
        newMessage.setSubject("Welcome Subscriber");
        newMessage.setText("Hi, and greetings from fatima,shaimaa and esraa");
        javaMailSender.send(newMessage);
        System.out.println("send...ok");
    }
}
