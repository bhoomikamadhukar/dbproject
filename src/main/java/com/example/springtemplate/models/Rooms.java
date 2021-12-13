package com.example.springtemplate.models;

import java.sql.Date;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Rooms {

    @Id
    @GeneratedValue
            (strategy = GenerationType.IDENTITY)
    private int id;


    private int numberofBeds;
    private Types type;
    private boolean isRefundable;
    private double cost;
    private boolean miniBar;
    private boolean complementaryBreakfast;
    private boolean isAvailable;
    @JsonFormat(pattern="MM/dd/yyyy", timezone="UTC")
    private Date checkIn;
    @JsonFormat(pattern="MM/dd/yyyy", timezone="UTC")
    private Date checkOut;



    public Rooms() {
    }

    public Rooms(double cost, boolean isRefundable,int numberofBeds,  boolean miniBar,
                       boolean complementaryBreakfast,Types type, boolean isAvailable,
                       Date checkIn, Date checkOut) {
        this.numberofBeds = numberofBeds;
        this.type = type;
        this.isRefundable = isRefundable;
        this.cost = cost;
        this.miniBar = miniBar;
        this.complementaryBreakfast = complementaryBreakfast;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.isAvailable = isAvailable;


    }


    @OneToMany(mappedBy = "rooms", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Bookings> bookings;

    @ManyToOne
    @JsonIgnore
    public Hotels hotels;


    public List<Bookings> getBookings() {
        return bookings;
    }

    public void setBookingDetails(List<Bookings> bookings) {
        this.bookings = bookings;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public boolean isRefundable() {
        return isRefundable;
    }

    public void setRefundable(boolean refundable) {
        isRefundable = refundable;
    }
    public int getNumberofBeds() {
        return numberofBeds;
    }

    public void setNumberofBeds(int numberofBeds) {
        this.numberofBeds = numberofBeds;
    }



    public boolean hasMiniBar() {
        return miniBar;
    }

    public void setHasMiniBar(boolean miniBar) {
        this.miniBar = miniBar;
    }



    public boolean hasComplementaryBreakfast() {
        return complementaryBreakfast;
    }

    public void setHasComplementaryBreakfast(boolean complementaryBreakfast) {
        this.complementaryBreakfast = complementaryBreakfast;
    }




    public Date getCheckInDate() {
        return checkIn;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkIn = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOut;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOut = checkOutDate;
    }

    public Boolean isAvailable(){
        return isAvailable;
    }

    public void setAvailable (Boolean isAvailable){
        this.isAvailable=isAvailable;
    }

    public Hotels getHotel() {
        return hotels;
    }


    public void setHotel(Hotels hotels) {
        this.hotels = hotels;
    }
}

