package com.example.demo.Implementation;

import com.example.demo.Modal.Admin;
import com.example.demo.Modal.Donor;
import com.example.demo.Modal.Recipient;
import com.example.demo.Repository.AdminRepoitory;
import com.example.demo.Repository.DonorRepository;
import com.example.demo.Repository.RecipientRepository;
import com.example.demo.Service.AdminService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminImplementation implements AdminService {

    private AdminRepoitory adminRepoitory;
    private RecipientRepository recipientRepository;
    private DonorRepository donorRepository;
@Autowired
    public AdminImplementation(AdminRepoitory adminRepoitory, RecipientRepository recipientRepository, DonorRepository donorRepository) {
        this.adminRepoitory = adminRepoitory;
    this.recipientRepository = recipientRepository;
    this.donorRepository = donorRepository;
}

    @Override
    public void save(Admin admin) {
        if (admin!=null){
         adminRepoitory.save(admin);
        }
    }

    @Override
    public void Approval(String id) {
        Optional<Recipient> optionalSeller = recipientRepository.findById(id);
        if (optionalSeller.isPresent()) {
            Recipient seller = optionalSeller.get();
            seller.setRStatus("Approved");

            // Save the updated seller back to the repository
            recipientRepository.save(seller);
        } else {
            // Handle the case where the seller with the given id is not found
            // You can throw an exception, log a message, or handle it according to your application's requirements
        }
    }
    @Override
    public void Disapproval(String id) {
        Optional<Recipient> optionalSeller = recipientRepository.findById(id);
        if (optionalSeller.isPresent()) {
            Recipient seller = optionalSeller.get();
            seller.setRStatus("Disapproved");
            // Save the updated seller back to the repository
            recipientRepository.save(seller);
        }
    }
    @Override
    public Admin findById(String id) {
        return adminRepoitory.findById(id).orElse(null);
    }
    @Override
    public void DApproval(String id) {
        if (id != null) {
            // Find the Recipient by its ObjectId
            Donor donor = donorRepository.findById(id).orElse(null);
            System.out.println(donor);
            // Check if the Recipient exists
            if (donor!=null) {
                // Update the Recipient's status
                donor.setAppproval("Approved");

                // Save the updated Recipient back to the repository
                donorRepository.save(donor);
            } else {
                System.out.println("Recipient not found for id: " + id);
            }
        } else {
            System.out.println("Invalid id provided: " + id);
        }
    }




    @Override
    public void DDpproval(String id) {
        Optional<Donor> optionalDonor=donorRepository.findById(id);
        if (optionalDonor.isPresent()){
            Donor donor=optionalDonor.get();
            donor.setAppproval("Disapproved");
            donorRepository.save(donor);
        }
    }




}
