package com.example.disertatie.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Program implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    private int duration;

    public Program() {}

    public Program(Schedule schedule, Destination destination, int duration) {
        this.schedule = schedule;
        this.destination = destination;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Program{" + "id=" + id + ", duration=" + duration + '}';
    }
}
