package com.example.springtemplate.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.springtemplate.models.Employees;
import com.example.springtemplate.models.Hotels;
public interface EmployeeRepository extends CrudRepository<Employees,Integer>{
//    @Query("SELECT hotel from Employees emp join Hotels hotel on emp.hotel.id=hotel.id " +
//            "where emp.id=:id")
//    Hotels findHotelByEmployeeId(@Param("id") int id
//    );




}
