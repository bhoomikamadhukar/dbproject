package com.example.springtemplate.models;
import java.sql.Date;


import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="guests")
public class Guests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date dob;
    private String gender;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "guest", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("guest")
    private List<Bookings> bookings;

    @OneToMany(mappedBy = "guest1", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("guest1")
    private List<Review> reviews;

    public Guests(){
    }

    public Guests(String firstName, String lastName, String email, String password, Date dob,
                String gender, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.address=address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

   public Address getAddress(){
        return address;
   }
   public void setAddress(Address address){
        this.address=address;
   }

    public List<Bookings> getBookings() {
        return bookings;
    }

    public void setBookings(List<Bookings> booking) {
        this.bookings = booking;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }




}
