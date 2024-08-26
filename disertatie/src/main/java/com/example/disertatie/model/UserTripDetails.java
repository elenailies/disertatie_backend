package com.example.disertatie.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class UserTripDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    // Additional fields, if needed (e.g., booking date, status)
    private String bookingDate;

    public UserTripDetails() {}

    public UserTripDetails(User user, Trip trip, String bookingDate) {
        this.user = user;
        this.trip = trip;
        this.bookingDate = bookingDate;
    }

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

    @Override
    public String toString() {
        return "UserTripDetails{" +
                "id=" + id +
                ", user=" + user.getUsername() +
                ", trip=" + trip.getName() +
                ", bookingDate='" + bookingDate + '\'' +
                '}';
    }
}
