package com.example.disertatie.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Destination implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;
    private String map;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, orphanRemoval = true)
    // private Set<Program> programs;

    public Destination() {}

    public Destination(String name, String address, String map) { // Modified constructor
        this.name = name;
        this.address = address;
        this.map = map;
    }

    // Getters and Setters

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // public Set<Program> getPrograms() {
    //     return programs;
    // }

    // public void setPrograms(Set<Program> programs) {
    //     this.programs = programs;
    // }

    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", map='" + map + '\'' + // Included map in toString
                '}';
    }
}
