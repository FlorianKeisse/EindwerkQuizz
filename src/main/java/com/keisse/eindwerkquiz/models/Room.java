package com.keisse.eindwerkquiz.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Room {

    @Id
    private Long id;

    @OneToMany
    private List<User> users;

    @OneToMany
    private List<Question> questions;

    public List<User> getUsers() {
        return users;
    }

    public void setUser(User user) {
        users.add(user);
        System.out.println(users);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room() {
    }

    public Room(List<User> users) {
        this.users = users;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
