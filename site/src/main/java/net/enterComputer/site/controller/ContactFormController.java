package net.enterComputer.site.controller;

import net.enterComputer.site.model.ContactUs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactFormController {

    @GetMapping("/contactForm")
    public String show(Model model){
        model.addAttribute("ContactUs",new ContactUs());
        return "index";
    }

    @PostMapping("/contactForm")
    public String submitConForm(@ModelAttribute ContactUs contactUs ,
                                Model model){
        model.addAttribute("ContactUs",contactUs);
        return "redirect:/message_send";
    }
}
