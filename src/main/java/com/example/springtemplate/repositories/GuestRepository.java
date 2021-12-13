package com.example.springtemplate.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.example.springtemplate.models.Guests;

import java.util.List;

public interface GuestRepository extends CrudRepository<Guests, Integer>{

@Query(value = "SELECT * FROM guests", nativeQuery = true)
public List<Guests> findAllGuests();

@Query(value = "SELECT * FROM guests WHERE id=:guestId",
        nativeQuery = true)
public Guests findGuestById(@Param("guestId") Integer id);



}
