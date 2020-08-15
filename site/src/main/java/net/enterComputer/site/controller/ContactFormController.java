package net.enterComputer.site.controller;

import net.enterComputer.site.model.ContactUs;
import net.enterComputer.site.repositroy.ContactUsRepository;
import net.enterComputer.site.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jca.cci.RecordTypeNotSupportedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;


@Controller
public class ContactFormController {

    ContactUsRepository repository;
    ContactUsService contactUsService;


    //accept new income
    @GetMapping( path = "/")
    public String show(Model model) {
        model.addAttribute("contactUs", new ContactUs());
        return "index";
    }


    @PostMapping("/contactForm")
    public String submitConForm(@ModelAttribute ContactUs contactUs ,
                                Model model){
        model.addAttribute("ContactUs",contactUs);
//        ContactUs update = contactUsService.createNewMessage(contactUs);
//        contactUsService.saveMessage(update);
        return "send-message";
    }

    //how to do in java code
//    @PostMapping("/contactForm")
//    public ResponseEntity<ContactUs> createNewMessage(ContactUs contactUs)
//            throws RecordTypeNotSupportedException {
//        ContactUs update = contactUsService.createNewMessage(contactUs);
//        return new ResponseEntity<>(update, new HttpHeaders(), HttpStatus.OK);
//    }




}
