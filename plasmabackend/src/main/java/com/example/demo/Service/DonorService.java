package com.example.demo.Service;

import com.example.demo.Modal.Admin;
import com.example.demo.Modal.Donor;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DonorService {
    void save(Donor donor);

    List<Donor> findAll();

    Donor findById(String id);

    List<Admin> findByStateCityAndDate(String AState, String ACity, LocalDate localDate);
}
