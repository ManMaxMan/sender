package com.github.ManMaxMan.sender.dao.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Table(name = "messages", schema = "app")
@Entity
public class MessageEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_create")
    private LocalDateTime dateCreate;

    private String recipient;

    private String subject;

    @Column(name = "text")
    private String body;

    public MessageEntity() {
    }

    public MessageEntity(Long id, LocalDateTime dateCreate, String recipient, String subject, String body) {
        this.id = id;
        this.dateCreate = dateCreate;
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
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

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", dateCreate=" + dateCreate +
                ", recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
