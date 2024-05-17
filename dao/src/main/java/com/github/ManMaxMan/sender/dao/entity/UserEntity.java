package com.github.ManMaxMan.sender.dao.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="users", schema = "app")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String password;
    private LocalDateTime birthday;
    private String fio;

    @Column(name = "dt_registration")
    private LocalDateTime dateRegistration;

    public UserEntity() {
    }

    public UserEntity(Long id, String login, String password, LocalDateTime birthday, String fio, LocalDateTime dateRegistration) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.birthday = birthday;
        this.fio = fio;
        this.dateRegistration = dateRegistration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LocalDateTime getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(LocalDateTime dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", fio='" + fio + '\'' +
                ", dateRegistration=" + dateRegistration +
                '}';
    }
}
