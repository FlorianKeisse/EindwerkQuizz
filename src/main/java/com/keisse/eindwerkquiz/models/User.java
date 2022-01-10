package com.keisse.eindwerkquiz.models;

import lombok.*;

import javax.persistence.*;

@ToString
@Entity
public class User {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String password;

    private boolean temp;

    @ManyToOne
    private Room room;

    @OneToOne
    private Punishment punishment;

    public User() {

    }
    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Punishment getPunishment() {
        return punishment;
    }

    public void setPunishment(Punishment punishment) {
        this.punishment = punishment;
    }

    public boolean isTemp() {
        User user = new User();
        if (user.getPassword()==null){
            temp = true;
        }
        return temp;
    }

    public void setTemp(boolean temp) {
        User user = new User();
        if (user.getPassword()==null){
            temp = true;
        }
        this.temp = temp;
    }
}
