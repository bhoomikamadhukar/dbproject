package com.example.springtemplate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comments;
    private int likes;

    public Review(String comments,int likes){
        this.likes=likes;
        this.comments=comments;
    }

    public int getLikes(){return likes;}
    public void setLikes(int likes){this.likes=likes;}

    public String getComments(){return comments;}
    public void setComments(String comments){this.comments=comments;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JsonIgnore
    public Guests guest1;


    @ManyToOne
    @JsonIgnore
    public Hotels hotels1;

    public Guests getGuest() {
        return this.guest1;
    }

    public void setGuest(Guests guest1) {
        this.guest1 = guest1;

    }

    public Hotels getHotel() {
        return this.hotels1;
    }
    public void setHotels(Hotels hotels1){this.hotels1=hotels1;}

    public Review() {
    }

}
