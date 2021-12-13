package com.example.springtemplate.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int apartment_num;
    private String street;
    private String city;
    private String state;
    private int zipcode;

    public Address() {
    }

    public Address(int apartment_num, String street, String city, String state, int zipcode){
        this.apartment_num=apartment_num;
        this.street=street;
        this.city=city;
        this.state=state;
        this.zipcode=zipcode;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id =id;
    }

    public int getApartment_num(){
        return apartment_num;
    }
    public void setApartment_num(int apartment_num){
        this.apartment_num =apartment_num;
    }

    public String getStreet(){
        return street;
    }
    public  void setStreet(String street){
        this.street=street;
    }
    public String getCity(){
        return city;
    }
    public  void setCity(String city){
        this.city=city;
    }
    public String getState(){
        return state;
    }
    public  void setState(String state){
        this.state=state;
    }

    public int getZipcode(){
        return zipcode;
    }
    public  void setZipcode(int zipcode){
        this.zipcode=zipcode;
    }




}

