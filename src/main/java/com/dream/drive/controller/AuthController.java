package com.dream.drive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Custom authentication logic (if necessary)
        // This is where you could verify the user's credentials against a database
        
        return "redirect:/listCars"; // Redirect to the list of cars or another page
    }
}