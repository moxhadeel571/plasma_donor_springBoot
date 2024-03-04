package com.example.demo.Implementation;

import com.example.demo.Modal.Admin;
import com.example.demo.Modal.Donor;
import com.example.demo.Repository.DonorRepository;
import com.example.demo.Service.DonorService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DonorImplementation implements DonorService {
    private DonorRepository donorRepository;
@Autowired
    public DonorImplementation(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @Override
    public void save(Donor donor) {
//            Donor donor1=new Donor();
//            donor1.setId(donor.getId());
//            donor1.setAddress(donor.getAddress());
//            donor1.setAvailability(donor.getAvailability());
//            donor1.setName(donor.getName());
//            donor1.setAge(donor.getAge());
//            donor1.setBloodType(donor.getBloodType());
//            donor1.setContactInfo(donor.getContactInfo());
//            donor1.setDonationHistory(donor.getDonationHistory());
//            donor1.setCOVIDStatus(donor.getCOVIDStatus());
            donorRepository.save(donor);
    }

    @Override
    public List<Donor> findAll() {
        return donorRepository.findAll();
    }

    @Override
    public Donor findById(String id) {
        return donorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Admin> findByStateCityAndDate(String AState, String ACity, LocalDate localDate) {
        return donorRepository.findByStateCityAndDate(AState, ACity, localDate);
    }
}
