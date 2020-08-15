package net.enterComputer.site.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity(name = "contactus")
@NamedQueries({
        @NamedQuery(name = "Contactus.findAll", query = "SELECT c FROM contactus c"),
        @NamedQuery(name = "Contactus.findByUserName", query = "SELECT c FROM contactus c WHERE c.userName = :userName"),
        @NamedQuery(name = "Contactus.findByUserEmail", query = "SELECT c FROM contactus c WHERE c.userEmail = :userEmail"),
        @NamedQuery(name = "Contactus.findBySubject", query = "SELECT c FROM contactus c WHERE c.subject = :subject"),
        @NamedQuery(name = "Contactus.findByMessage", query = "SELECT c FROM contactus c WHERE c.message = :message")})
public class ContactUs implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USER_NAME")
    private String userName;

    @Email
    @Size(max = 30)
    @Column(name = "USER_EMAIL")
    private String userEmail;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SUBJECT")
    private String subject;

    @Size(max = 300)
    @Column(name = "MESSAGE")
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
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactUs)) {
            return false;
        }
        ContactUs other = (ContactUs) object;
        if ((this.userName == null && other.userName != null)
                || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.enterComputer.site ContactForm [ userName=" + userName + " ]";
    }

}
