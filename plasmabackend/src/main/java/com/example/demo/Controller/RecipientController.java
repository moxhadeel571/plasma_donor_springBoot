package com.example.demo.Controller;

import com.example.demo.Modal.Recipient;
import com.example.demo.Service.RecipientService;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/common")
@RestController
public class RecipientController {

    private RecipientService recipientService;
@Autowired
    public RecipientController(RecipientService recipientService) {
        this.recipientService = recipientService;
    }

    @PostMapping("/SaveRequest")
    public void saveRequest( Recipient recipient){
        recipientService.save(recipient);
    }
        @GetMapping("/FindAll")
    public List<Recipient> FindAll(){
        return recipientService.findAll();
    }@GetMapping("/fetch/{id}")
    public Optional<Recipient> getid(@PathVariable("id")String id){
        return recipientService.findById(id);
    }

}
