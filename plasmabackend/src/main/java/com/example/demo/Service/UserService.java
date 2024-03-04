package com.example.demo.Service;


import com.example.demo.Modal.User;
import org.springframework.stereotype.Service;


public interface UserService {



 User saveUser(User User);

 public void removeSuccessMessage();

}