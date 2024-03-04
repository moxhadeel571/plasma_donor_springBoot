package com.example.demo.Repository;

import com.example.demo.Modal.Admin;
import com.example.demo.Modal.Donor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository("DonorRepository")
public interface DonorRepository extends MongoRepository<Donor, String> {
    @Query("{ 'AState' : ?0, 'ACity' : ?1, 'localDate' : ?2 }")
    List<Admin> findByStateCityAndDate(String AState, String ACity, LocalDate localDate);


}
