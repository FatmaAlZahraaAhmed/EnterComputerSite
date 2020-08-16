package net.enterComputer.site.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity(name = "contactus")
public class ContactUs implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "userName")
    private String userName;

    @Email
    @Size(max = 30)
    @Column(name = "userEmail")
    private String userEmail;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "subject")
    private String subject;

    @Size(max = 300)
    @Column(name = "message")
    private String message;

    public ContactUs() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public ContactUs(String userName, String subject) {
        this.userName = userName;
        this.subject = subject;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "net.enterComputer.site ContactForm [ userName=" + userName + " ]";
    }

}
