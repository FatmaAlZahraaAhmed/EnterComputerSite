package net.enterComputer.site.service;

import net.enterComputer.site.model.ContactUs;
import net.enterComputer.site.repositroy.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.RecordTypeNotSupportedException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class ContactUsService {

    @Autowired
    ContactUsRepository repository;



    public ContactUs createNewMessage(ContactUs newMessage) throws
            RecordTypeNotSupportedException {
        /*Optional is a container object which may or may not
         contain a non-null value.
         You must import java.util package to use this class.
         If a value is present, isPresent() will return true
         and get() will return the value
         */
        Optional<ContactUs> messages = repository.findById(newMessage.getUserId());
        if (messages.isPresent()) {

            ContactUs newOne = messages.get();
            newOne.setUserName(newMessage.getUserName());
            newOne.setUserEmail(newMessage.getUserEmail());
            newOne.setSubject(newMessage.getSubject());
            newOne.setMessage(newMessage.getMessage());

            newOne = repository.saveAndFlush(newOne);

            return newOne;

        } else {
            newMessage = repository.saveAndFlush(newMessage);

            return newMessage;
        }
    }

    public ContactUs saveMessage(ContactUs contactUs) {
        return repository.save(contactUs);
    }

}
