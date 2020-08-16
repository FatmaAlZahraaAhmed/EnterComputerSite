package net.enterComputer.site.service;

import net.enterComputer.site.model.ContactUs;
import net.enterComputer.site.repositroy.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.RecordTypeNotSupportedException;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ContactUsServiceImpl implements Services {
    @Autowired
    private ContactUsRepository repository;

    @Override
    public void saveNewMessage(ContactUs message) {
        this.repository.save(message);
    }
}
