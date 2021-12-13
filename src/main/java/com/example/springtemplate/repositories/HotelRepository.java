package com.example.springtemplate.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import com.example.springtemplate.models.Hotels;
import com.example.springtemplate.models.Rooms;

public interface HotelRepository extends CrudRepository<Hotels,Integer>{

    @Query(value="SELECT * FROM hotels",nativeQuery = true)
    public List<Hotels> findAllHotels();

    @Query(value="SELECT hotel FROM Hotels hotel where hotel.name=:name")
    Hotels findHotelByName(@Param("name") String name);

    @Query("SELECT room from Rooms room join Hotels hotel on room.hotels.id=hotel.id " +
            "where room.hotels.id=:id")
    List<Rooms> findRoomsForHotel(@Param("id") int id);
}
