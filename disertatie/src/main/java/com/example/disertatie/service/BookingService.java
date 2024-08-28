package com.example.disertatie.service;

import com.example.disertatie.exception.UserNotFoundException;
import com.example.disertatie.model.Booking;
import com.example.disertatie.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepo bookingRepo;

    @Autowired
    public BookingService(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public Booking addBooking(Booking booking){
        //booking.setName(UUID.randomUUID().toString());
        return bookingRepo.save(booking);
    }

    public List<Booking> findAllBookings() {
        return bookingRepo.findAll();
    }

    public Booking updateBooking(Booking booking){
        return bookingRepo.save(booking);
    }

    public Booking findBookingById(Long id){
        return bookingRepo.findBookingById(id)
                .orElseThrow(() -> new UserNotFoundException("Booking by id " + id + " was not found"));
    }

    public void deleteBooking(Long id){
        bookingRepo.deleteBookingById(id);

    }

}
