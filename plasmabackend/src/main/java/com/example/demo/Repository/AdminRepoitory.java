package com.example.demo.Repository;

import com.example.demo.Modal.Admin;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepoitory extends MongoRepository<Admin, String> {

}
