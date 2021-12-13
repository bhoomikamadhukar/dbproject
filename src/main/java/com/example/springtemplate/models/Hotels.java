package com.example.springtemplate.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotels {

    @Id
    @GeneratedValue
            (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String about;
    private Rating rating;
    private Boolean hasGym;
    private Boolean hasLounge;
    private String city;
    private String street;
    private String state;
    private int contact;
    private int zipcode;


    @OneToMany(mappedBy = "hotels", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Rooms> rooms;

    @OneToMany(mappedBy = "hotels1", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Review> reviews;

    public Hotels() {

    }

    public Hotels(String name, Boolean hasGym, Boolean hasLounge, String about,
                  int contact, Rating rating, String street, String city, String state, int zipcode) {
        this.name = name;
        this.about = about;
        this.rating = rating;
        this.hasGym = hasGym;
        this.hasLounge = hasLounge;
        this.street = street;
        this.zipcode = zipcode;
        this.contact = contact;
        this.city=city;
        this.state=state;
    }


    public void setRooms(List<Rooms> rooms) {
        this.rooms = rooms;
    }

    public void setReviews(List<Review> reviews){
        this.reviews=reviews;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Boolean getHasGym() {
        return hasGym;
    }

    public void setHasGym(Boolean hasGym) {
        this.hasGym = hasGym;
    }

    public Boolean getHasLounge() {
        return hasLounge;
    }

    public void setHasLounge(Boolean hasLounge) {
        this.hasLounge = hasLounge;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public int getContact(){
        return contact;
    }
    public  void setContact(int contact){
        this.contact=contact;
    }



}
