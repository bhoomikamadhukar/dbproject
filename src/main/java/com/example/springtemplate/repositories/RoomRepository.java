package com.example.springtemplate.repositories;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import com.example.springtemplate.models.Rooms;
import com.example.springtemplate.models.Hotels;

public interface RoomRepository extends CrudRepository<Rooms,Integer> {

    @Query("SELECT room from Rooms room join Hotels hotel on room.hotels.id=hotel.id " +
            "where room.isAvailable=TRUE and room.checkIn >= :checkIn and room.checkOut <= :checkOut and " +
             "hotel.city=:city")
    List<Rooms> findRoomsForHotelAndDates(@Param("checkIn") Date checkIn,
                                               @Param("checkOut") Date checkOut,
                                               @Param("city") String city
    );

    @Transactional
    @Modifying
    @Query("DELETE from Bookings where guest.id=:guestId and id=:bookingId")
    void deleteBookingForGuest(@Param("bookingId") int bookingId,
                                  @Param("guestId") int guestId
    );

    @Query("SELECT hotel from Rooms rooms join Hotels hotel on rooms.hotels.id=hotel.id " +
            "where rooms.id=:id")
    Hotels findHotelByRoom(@Param("id") int id
    );
}
