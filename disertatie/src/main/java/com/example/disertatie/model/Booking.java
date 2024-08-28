package com.example.disertatie.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    private String bookingDate;

    private int nrTickets;  // Number of tickets

    @Column(precision = 10, scale = 2)
    private BigDecimal totalCost;  // Total cost of the booking

    public Booking() {}

    // Updated constructor to include nrTickets and totalCost
    public Booking(User user, Trip trip, String bookingDate, int nrTickets, BigDecimal totalCost) {
        this.user = user;
        this.trip = trip;
        this.bookingDate = bookingDate;
        this.nrTickets = nrTickets;
        this.totalCost = totalCost;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNrTickets() {
        return nrTickets;
    }

    public void setNrTickets(int nrTickets) {
        this.nrTickets = nrTickets;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", user=" + user.getUsername() +
                ", trip=" + trip.getName() +
                ", bookingDate='" + bookingDate + '\'' +
                ", nrTickets=" + nrTickets +
                ", totalCost=" + totalCost +
                '}';
    }
}
