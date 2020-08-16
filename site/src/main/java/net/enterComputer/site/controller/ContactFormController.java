package net.enterComputer.site.controller;

import net.enterComputer.site.model.ContactUs;
import net.enterComputer.site.repositroy.ContactUsRepository;
import net.enterComputer.site.service.ContactUsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ContactFormController {

    @Autowired
    private ContactUsRepository repository;
    @Autowired
    private ContactUsServiceImpl contactUsServiceImpl;


    //accept new income
    @GetMapping(path = {"/","/index.html"})
    public String show(Model model) {
        model.addAttribute("ContactUs", new ContactUs());
        return "index";
    }


    @PostMapping("/contactForm")
    public String submitConForm(@ModelAttribute("ContactUs") ContactUs contactUs,
                                Model model) {
        contactUsServiceImpl.saveNewMessage(contactUs);
        return "send-message";
    }


}
