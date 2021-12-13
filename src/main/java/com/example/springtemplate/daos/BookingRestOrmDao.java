package com.example.springtemplate.daos;


import com.example.springtemplate.models.Bookings;
import com.example.springtemplate.models.Guests;
import com.example.springtemplate.repositories.BookingRepository;
import com.example.springtemplate.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BookingRestOrmDao {
    @Autowired
    BookingRepository bookingRepository;
    RoomRepository roomRepository;

    @GetMapping("/api/bookings")
    public List<Bookings> findAllBookings() {
        return bookingRepository.findAllBookings();
    }

    @GetMapping("/api/bookings/{bookingId}")
    public Bookings findBookingById(
            @PathVariable("bookingId") Integer id) {
        return bookingRepository.findBookingById(id);
    }

    @GetMapping("/api/bookings/guest/{guestId}")
    public List<Bookings> findBookingByGuestId(
    @PathVariable("guestId") Integer id){
        return bookingRepository.findBookingForGuestsById(id);
    }

    @PostMapping("/api/bookings")
    public Bookings createBookings(@RequestBody Bookings booking) {
        return bookingRepository.save(booking);
    }

    @PutMapping("/api/bookings/{bookingId}")
    public Bookings updateBooking(
            @PathVariable("bookingId") Integer id,
            @RequestBody Bookings bookingUpdate) {
        Bookings booking = bookingRepository.findBookingById(id);
        booking.setCheckInDate(bookingUpdate.getCheckInDate());
        booking.setCheckOutDate(bookingUpdate.getCheckOutDate());
        booking.setNumberOfGuests(bookingUpdate.getNumberOfGuests());
        booking.setPayment(bookingUpdate.getPayment());
        return bookingRepository.save(booking);
    }

    @DeleteMapping("/api/bookings/{bookingId}")
    public void deleteBooking(
            @PathVariable("bookingId") Integer id) {
        bookingRepository.deleteById(id);
    }
}