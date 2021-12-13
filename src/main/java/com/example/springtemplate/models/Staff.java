package com.example.springtemplate.models;
import javax.persistence.*;


@Entity
public class Staff extends Employees{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Staff(){
        super();
    }

    public Staff(String firstName,String lastName,String email,String password,String gender,float salary,String department,String job_title) {
        super(firstName, lastName, email, password, gender, salary, department, job_title);
    }

    @ManyToOne
    private Manager manager;

    @Override
    public int getId(){
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Manager getManager(){return manager;}

    public void setManager(Manager manager){this.manager=manager;}

}
