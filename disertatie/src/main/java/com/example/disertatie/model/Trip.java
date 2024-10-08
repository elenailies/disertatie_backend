package com.example.disertatie.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Trip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String startTime;
    private String endTime;
    @Column(precision = 10, scale = 2)
    private BigDecimal ticketPrice;
    private String date;
    private Integer nrTickets;
    private String map; // Existing field

    @Column(nullable = false)
    private boolean enabled; // New boolean field

    public Trip() {
        this.enabled = true; // Initialize the default value
    }

    // Updated constructor to include nrTickets, map, and enabled
    public Trip(String name, String startTime, String endTime, BigDecimal ticketPrice, String date, Integer nrTickets, String map, boolean enabled) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ticketPrice = ticketPrice;
        this.date = date;
        this.nrTickets = nrTickets;
        this.map = map;
        this.enabled = enabled;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getNrTickets() {
        return nrTickets;
    }

    public void setNrTickets(Integer nrTickets) {
        this.nrTickets = nrTickets;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    //@OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    //private Set<UserTripDetails> userTripDetails;

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", date='" + date + '\'' +
                ", nrTickets=" + nrTickets +
                ", map='" + map + '\'' +
                ", enabled=" + enabled + // Updated toString method
                '}';
    }
}
