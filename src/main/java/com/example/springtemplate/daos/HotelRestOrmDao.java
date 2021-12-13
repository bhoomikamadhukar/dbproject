package com.example.springtemplate.daos;



import com.example.springtemplate.models.Hotels;
import com.example.springtemplate.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class HotelRestOrmDao {
    @Autowired
    HotelRepository hotelRepository;

    @GetMapping("/api/hotels")
    public List<Hotels> findAllHotels() {
        return hotelRepository.findAllHotels();
    }

}
