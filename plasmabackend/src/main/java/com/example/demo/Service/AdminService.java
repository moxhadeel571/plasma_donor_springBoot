package com.example.demo.Service;

import com.example.demo.Modal.Admin;
import com.example.demo.Modal.Recipient;
import org.bson.types.ObjectId;

public interface AdminService {
    void save(Admin admin);


    void Approval(String id);

    void Disapproval(String id);

    Admin findById(String id);

    void DApproval(String id);

    void DDpproval(String id);

}
