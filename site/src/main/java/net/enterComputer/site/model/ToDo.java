package net.enterComputer.site.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//only by creating this class and annotated with
//@Entity && @Table(name = "ToDo")
// and creating all the getter and setter and no args constructor
//it creates the table for us in DB
@Entity
@Table(name = "ToDo")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "body")
    private String body;

    @Column(name = "to_whome")
    private String to_whome;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTo_whome() {
        return to_whome;
    }

    public void setTo_whome(String to_whome) {
        this.to_whome = to_whome;
    }

}
