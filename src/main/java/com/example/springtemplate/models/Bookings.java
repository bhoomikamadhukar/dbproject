package com.example.springtemplate.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numberOfGuests;
    private Payment payment;
    @JsonFormat(pattern="MM/dd/yyyy", timezone="UTC")
    private Date checkInDate;
    @JsonFormat(pattern="MM/dd/yyyy", timezone="UTC")
    private Date checkOutDate;


    public Bookings() {
    }

    public Bookings(Date checkInDate, Date checkOutDate, int numberOfGuests) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfGuests = numberOfGuests;
    }


    @ManyToOne
    @JsonIgnoreProperties("bookings")
    public Guests guest;


    @ManyToOne
    @JsonIgnoreProperties("bookings1")
    public Rooms rooms;

    public Guests getGuest() {
        return guest;
    }

    public void setGuest(Guests guest) {
        this.guest = guest;
        if (!guest.getBookings().contains(this)) {
        }
    }

    public void setBooking(Guests guest) {
        this.guest = guest;
        if (!guest.getBookings().contains(this)) {
            guest.getBookings().add(this);
        }
    }

    public void setRoomBooking(Rooms rooms) {
        this.rooms = rooms;
    }



    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;

    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


}
