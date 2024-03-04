package com.example.demo.Repository;

import com.example.demo.Modal.Recipient;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("recipient")
public interface RecipientRepository extends MongoRepository<Recipient, String> {
}
