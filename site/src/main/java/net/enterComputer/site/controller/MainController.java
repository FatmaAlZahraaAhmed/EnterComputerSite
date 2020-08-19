package net.enterComputer.site.controller;

import net.enterComputer.site.model.ContactUs;
import net.enterComputer.site.model.RegisterAccount;
import net.enterComputer.site.model.Subscriber;
import net.enterComputer.site.model.ToDo;
import net.enterComputer.site.repositroy.ContactUsRepository;
import net.enterComputer.site.service.AccountServiceImpl;
import net.enterComputer.site.service.ContactUsServiceImpl;
import net.enterComputer.site.service.SendEmailService;
import net.enterComputer.site.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {

    @Autowired
    private ContactUsServiceImpl contactUsServiceImpl;
    @Autowired
    private SendEmailService sendEmailService;
    @Autowired
    private ToDoService toDoService;
    @Autowired
    private AccountServiceImpl accountService;

    //accept new income
    @GetMapping(path = {"/", "/index.html"})
    public String show(Model model) {
        model.addAttribute("ContactUs", new ContactUs());
        return "index";
    }

    @GetMapping("/getStarted.html")
    public String viewGetStarted(Model model) {
        model.addAttribute("RegisterAccount", new RegisterAccount());
        return "getStarted";
    }

    @PostMapping("/register")
    public String submitRegister(@ModelAttribute("RegisterAccount") RegisterAccount account) {
        accountService.saveNewAccount(account);
        return "index";
    }

    @PostMapping("/contactForm")
    public String submitConForm(@ModelAttribute("ContactUs") ContactUs contactUs,
                                Model model) {
        contactUsServiceImpl.saveNewMessage(contactUs);
        return "send-message";
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@ModelAttribute("Subscriber") Subscriber subscriber) {
        sendEmailService.sendEmail(subscriber);
        return "send-message";
    }


    @GetMapping("/tdl.html")
    public String viewTDL(Model model) {
        //is the model that is displayed in ToDoList page
        model.addAttribute("ListOfToDos", toDoService.getAllToDos());
        return "tdl";
    }

    //submit btn to add new To-Do
    @GetMapping("/showNewTodoForm")
    public String showNewTodoForm(Model model) {
        ToDo toDo = new ToDo();
        model.addAttribute("ToDo", toDo);
        return "newToDo";//the return page
    }

    @PostMapping("/saveToDo")
    //the object==table name==modelAttribute to hold the data
    public String saveToDo(@ModelAttribute("ToDo") ToDo toDo) {
        toDoService.saveToDo(toDo);
        return "redirect:/tdl.html";
    }

    @GetMapping("/showFormForUpdate/{id}")
    //when update btn is hit
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        // get the to-do from service
        ToDo todo = toDoService.getToDoById(id);
        // set to-do as a model attribute to add to form
        model.addAttribute("ToDo", todo);
        return "update-todo";//return form update the info
    }

    @GetMapping("/deleteToDo/{id}")
    //delete btn is hit
    //get the one byId
    public String deleteToDo(@PathVariable(value = "id") long id, Model model) {
        this.toDoService.deleteToDoById(id);
        return "redirect:/tdl.html";//return to TDL page
    }

}
