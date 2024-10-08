package com.example.disertatie.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // The user who asked the question

    @Column(nullable = false)
    private boolean enabled; // New boolean field

    //@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    //private Set<Answer> answers;

    public Question() {
        this.enabled = true; // Initialize the default value
    }

    public Question(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.enabled = true; // Initialize the default value
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    //public Set<Answer> getAnswers() {
    //    return answers;
    //}
    //public void setAnswers(Set<Answer> answers) {
    //    this.answers = answers;
    //}

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user.getUsername() +
                ", enabled=" + enabled +
                '}';
    }
}
