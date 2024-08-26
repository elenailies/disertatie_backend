package com.example.disertatie.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Schedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Program> programs;

    public Schedule() {}

    public Schedule(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(Set<Program> programs) {
        this.programs = programs;
    }

    @Override
    public String toString() {
        return "Schedule{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
