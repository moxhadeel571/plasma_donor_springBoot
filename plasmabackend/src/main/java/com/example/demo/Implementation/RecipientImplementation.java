package com.example.demo.Implementation;

import com.example.demo.Modal.Recipient;
import com.example.demo.Repository.RecipientRepository;
import com.example.demo.Service.RecipientService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RecipientImplementation implements RecipientService {

    private RecipientRepository recipientRepository;

    @Autowired
    public RecipientImplementation(RecipientRepository recipientRepository) {
        this.recipientRepository = recipientRepository;
    }

    @Override
    public void save(Recipient recipient) {
        recipientRepository.save(recipient);

    }

    @Override
    public List<Recipient> findAll() {
        return recipientRepository.findAll();
    }

    @Override
    public Optional<Recipient> findById(String                id) {
        return recipientRepository.findById(id);
    }
}
