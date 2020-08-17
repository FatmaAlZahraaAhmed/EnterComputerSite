package net.enterComputer.site.controller;

import net.enterComputer.site.model.ContactUs;
import net.enterComputer.site.model.Subscriber;
import net.enterComputer.site.repositroy.ContactUsRepository;
import net.enterComputer.site.service.ContactUsServiceImpl;
import net.enterComputer.site.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {

    @Autowired
    private ContactUsRepository repository;
    @Autowired
    private ContactUsServiceImpl contactUsServiceImpl;
    @Autowired
    private SendEmailService sendEmailService;


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
    @PostMapping("/sendEmail")
    public String sendEmail(@ModelAttribute("Subscriber")Subscriber subscriber){
        sendEmailService.sendEmail(subscriber);
        return "send-message";
    }

   /* @GetMapping("/tdl.html")
    public String showTDL(Model model){
        model.addAttribute("",);
        return "tdl";
    }
*/

}
