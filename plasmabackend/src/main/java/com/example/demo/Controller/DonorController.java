package com.example.demo.Controller;

import com.example.demo.Modal.Admin;
import com.example.demo.Modal.Donor;
import com.example.demo.Service.AdminService;
import com.example.demo.Service.DonorService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/common")
@RestController
public class DonorController {
private DonorService donorService;
private AdminService adminService;
@Autowired
    public DonorController(DonorService donorService, AdminService adminService) {
        this.donorService = donorService;
    this.adminService = adminService;
}

    @PostMapping("/DonorRequest")
    public void saveDonor( Donor donor){
    donorService.save(donor);
}
@GetMapping("/findAll")
    public List<Donor> getDonor(){
    return donorService.findAll();
}
@GetMapping("/findById/{id}")
    public Donor getFIndByID(@PathVariable("id")String id){
    return donorService.findById(id);
}

    @GetMapping("/SearchCamp")
    public List<Admin> searchCamp(@RequestParam String AState, @RequestParam String ACity, @RequestParam LocalDate localDate){
        return donorService.findByStateCityAndDate(AState, ACity, localDate);
    }

}
