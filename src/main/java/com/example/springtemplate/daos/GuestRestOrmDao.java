package com.example.springtemplate.daos;

import com.example.springtemplate.models.Guests;
import com.example.springtemplate.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class GuestRestOrmDao {
    @Autowired
    GuestRepository guestRepository;

    @GetMapping("/api/guests")
    public List<Guests> findAllGuests() {
        return guestRepository.findAllGuests();
    }

    @GetMapping("/api/guests/{guestId}")
    public Guests findGuestById(
            @PathVariable("guestId") Integer id) {
        return guestRepository.findGuestById(id);
    }
    @PostMapping("/api/guests")
    public Guests createGuest(@RequestBody Guests guest) {
        return guestRepository.save(guest);
    }

    @PutMapping("/api/guests/{guestId}")
    public Guests updateGuest(
            @PathVariable("guestId") Integer id,
            @RequestBody Guests guestUpdates) {
        Guests guest = guestRepository.findGuestById(id);
        guest.setFirstName(guestUpdates.getFirstName());
        guest.setLastName(guestUpdates.getLastName());
        guest.setEmail(guestUpdates.getEmail());
        guest.setPassword(guestUpdates.getPassword());
        guest.setDob(guestUpdates.getDob());
        guest.setGender(guestUpdates.getGender());
        return guestRepository.save(guest);
    }

    @DeleteMapping("/api/guests/{guestId}")
    public void deleteGuest(
            @PathVariable("guestId") Integer id) {
        guestRepository.deleteById(id);
    }
}
