package com.example.springtemplate.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Manager extends Employees{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numberOfEmployeesManaged;

    public Manager(){
        super();
    }

    public Manager(String firstName,String lastName,String email,String password,String gender,float salary,String department,String job_title){
        super(firstName,lastName,email,password,gender,salary,department,job_title);
    }

    @Override
    public int getId(){
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfEmployeesManaged(){
        return numberOfEmployeesManaged;
    }
    public void setNumberOfEmployeesManaged(int numberOfEmployeesManaged){
    }



}
