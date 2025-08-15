package com.revision.rev2.Controllers;

import com.revision.rev2.Models.Users;
import com.revision.rev2.Services.HomeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HomeController
{
    @Autowired
    private HomeService homeService;

    @GetMapping("/home")
    public ResponseEntity<String> greet()
    {
        return ResponseEntity.ok("Hi bhai");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users user)
    {
        homeService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user)
    {
        boolean status = homeService.loginUser(user);
        if(status)
        {
            return ResponseEntity.ok("Login successful");
        }
        else{
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}