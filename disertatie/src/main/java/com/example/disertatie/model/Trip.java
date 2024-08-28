package com.example.disertatie.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

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
    private Integer nrTickets; // New field added

    public Trip() {}

    // Updated constructor to include nrTickets
    public Trip(String name, String startTime, String endTime, BigDecimal ticketPrice, String date, Integer nrTickets) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ticketPrice = ticketPrice;
        this.date = date;
        this.nrTickets = nrTickets;
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

    public Integer getNrTickets() { // New getter
        return nrTickets;
    }

    public void setNrTickets(Integer nrTickets) { // New setter
        this.nrTickets = nrTickets;
    }

    //@OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    //private Set<UserTripDetails> userTripDetails;

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", ticketPrice=" + ticketPrice +
                ", date=" + date +
                ", nrTickets=" + nrTickets +  // Updated toString method
                '}';
    }
}
