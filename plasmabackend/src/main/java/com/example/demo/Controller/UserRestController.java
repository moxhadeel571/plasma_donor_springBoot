package com.example.demo.Controller;

import com.example.demo.Implementation.CustomUserDetailsService;
import com.example.demo.Modal.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.Arrays;
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/auth")
@RestController
public class UserRestController {
    private BCryptPasswordEncoder passwordEncoder;

    private UserService userService;
private final UserRepository customUserDetailsService;
    @Autowired
    public UserRestController(BCryptPasswordEncoder passwordEncoder, UserService userService, UserRepository customUserDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.customUserDetailsService = customUserDetailsService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        // Retrieve user from the database based on provided email
        User existingUser = customUserDetailsService.findByEmail(user.getEmail());

        // Check if user exists and password matches
        if (existingUser != null && passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            // Authentication successful
            System.out.println("User authenticated successfully.");

            // Print user's role
            System.out.println("User role: " + existingUser.getRoles());

            // Return the user object with roles
            return ResponseEntity.ok(existingUser);
        } else {
            // Authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }




    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.ok("User registered successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user: " + e.getMessage());
        }
    }
    @GetMapping("/logout")
    public ResponseEntity<String> registerLogout() {
        try {
            return ResponseEntity.ok("User Logout successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user: " + e.getMessage());
        }
    }
}
