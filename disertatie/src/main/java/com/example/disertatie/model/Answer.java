package com.example.disertatie.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Answer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // The user who provided the answer

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question; // The question being answered

    public Answer() {}

    public Answer(String content, User user, Question question) {
        this.content = content;
        this.user = user;
        this.question = question;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", user=" + user.getUsername() +
                ", question=" + question.getTitle() +
                '}';
    }
}
