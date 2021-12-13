package com.example.springtemplate.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.example.springtemplate.models.Bookings;
import com.example.springtemplate.models.Guests;

public interface BookingRepository extends CrudRepository<Bookings, Integer> {

    @Query("SELECT booking FROM Bookings booking where booking.guest.id=:guestId")
    List<Bookings> findBookingForGuestsById(@Param("guestId")int guestId);

    @Query(value = "SELECT * FROM Bookings", nativeQuery = true)
    List<Bookings> findAllBookings();

    @Query(value = "SELECT * FROM Bookings WHERE id=:bookingId",
            nativeQuery = true)
    public Bookings findBookingById(@Param("bookingId") Integer id);
}