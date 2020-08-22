package net.enterComputer.site.service;

import net.enterComputer.site.model.RegisterAccount;
import net.enterComputer.site.model.SWOT;
import net.enterComputer.site.repositroy.SWOTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SwotServiceImpl implements SwotService {
    @Autowired
    SWOTRepository repository;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void saveSWOT(SWOT swot) {
        this.repository.save(swot);
    }

    @Override
    public void sendSwotMail(SWOT swot) {
        System.out.println("message sending......");
        SimpleMailMessage newMessage = new SimpleMailMessage();
        newMessage.setTo("fatima.alzahraa.ahmed.ragab@gmail.com");
        newMessage.setFrom("totanoni25@gmail.com");
        newMessage.setSubject("Your SWOT Analysis");
        newMessage.setText("Hi, and Greetings" +"\n" +
                "This is our site EnterComputer for Software Solution" + "\n" +
                "created by Eng.Fatima Alzahraa," + "\n" +
                "Eng.Shaimaa And Eng.Esraa." + "\n" +
                "And this is your SWOT Analysis" +
                "\n"+
                "Your Strength are: "+swot.getStrength()+
                "\n"+
                "Your Weakness are: "+swot.getWeakness()+"\n"+
                "Your Opportunities are: "+swot.getOpportunity()+"\n"+
                "Your Threats are: "+swot.getThreat()+
                "\n"+
                "\n"+
                "Thank you");
        javaMailSender.send(newMessage);
        System.out.println("send...ok");

    }
}
