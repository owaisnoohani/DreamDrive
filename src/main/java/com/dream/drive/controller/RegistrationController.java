package com.dream.drive.controller;

import com.dream.drive.model.User;
import com.dream.drive.repository.UserRepository;
import com.dream.drive.service.EmailService;
import com.dream.drive.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OtpService otpService;

	@Autowired
	private EmailService emailService;

	private String generatedOtp;
	private User pendingUser;

	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user, Model model) {
		// Generate and send OTP
		generatedOtp = otpService.generateOtp();
		emailService.sendOtpEmail(user.getEmail(), generatedOtp);

		// Store user temporarily until OTP verification
		pendingUser = user;
		model.addAttribute("email", user.getEmail());
		return "verifyOtp";
	}

	@PostMapping("/verifyOtp")
	public String verifyOtp(@RequestParam String email, @RequestParam String otp, Model model) {

		System.out.println("otp :"+otp);
		if (otp.equals(generatedOtp) && pendingUser != null) {
			// Save the user after successful OTP verification
			userRepository.save(pendingUser);
			model.addAttribute("message", "Registration successful!");

			// Reset OTP and pending user for security
			generatedOtp = null;
			pendingUser = null;
			return "registrationSuccess";
		} else {
			model.addAttribute("error", "Invalid OTP. Please try again.");
			return "verifyOtp";
		}
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
}
