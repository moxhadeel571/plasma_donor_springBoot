package com.example.demo.Controller;

import com.example.demo.Modal.Admin;
import com.example.demo.Modal.Recipient;
import com.example.demo.Service.AdminService;
import com.example.demo.Service.RecipientService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping("/Admin")
@RestController
public class AdminController {
    private AdminService adminService;
    private RecipientService recipientService;

    public AdminController(AdminService adminService, RecipientService recipientService) {
        this.adminService = adminService;
        this.recipientService = recipientService;
    }

    @PostMapping("/SaveAdmin")
    public void SaveAdmin(Admin admin){
        adminService.save(admin);
    }
    @PostMapping("/Approval/{id}")
    public void Approval(@PathVariable("id") String id){
        adminService.Approval(id);
    }
    @PostMapping("/Disapproval/{id}")
    public void Disapproval(@PathVariable("id") String id){
        adminService.Disapproval(id);
    }
    @GetMapping("/findById/{id}")
    public Admin getAdmin(@PathVariable("id") String id){
        return adminService.findById(id);
    }
    @PostMapping("/DApproval/{id}")
    public ResponseEntity<String> DApproval(@PathVariable("id") String id) {
        // You can directly use the ObjectId id parameter here
        adminService.DApproval(id);

        return ResponseEntity.ok("DApproval successful");
    }

    @PostMapping("/DDpproval/{id}")
    public void DDpproval(@PathVariable("id") String id){
        adminService.DDpproval(id);
    }
}
