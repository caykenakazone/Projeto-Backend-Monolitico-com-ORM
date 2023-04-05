package com.exercicio2.exercicio2.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "email")
public class Email implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",nullable = false,length = 100)
    private String from;
    @Column(name = "last_name",nullable = false,length = 100)
    private String to;
    @Column(name = "subject",nullable = false,length = 100)
    private String subject;
    @Column(name = "body",nullable = false,length = 400)
    private String body;
    @Column(name = "attachment", nullable = false, length = 100)
    private String attachment;



    public Email() {}

    public Email(String from, String to, String subject, String body, String attachment) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.attachment = attachment;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }


    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", attachment='" + attachment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        if (!id.equals(email.id)) return false;
        if (!from.equals(email.from)) return false;
        if (!to.equals(email.to)) return false;
        if (!subject.equals(email.subject)) return false;
        if (!body.equals(email.body)) return false;
        return attachment.equals(email.attachment);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + from.hashCode();
        result = 31 * result + to.hashCode();
        result = 31 * result + subject.hashCode();
        result = 31 * result + body.hashCode();
        result = 31 * result + attachment.hashCode();
        return result;
    }
}
