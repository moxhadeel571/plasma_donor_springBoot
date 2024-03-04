package com.example.demo.Service;

import com.example.demo.Modal.Recipient;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface RecipientService {
    void save(Recipient recipient);

    List<Recipient> findAll();

    Optional<Recipient> findById(String id);
}
