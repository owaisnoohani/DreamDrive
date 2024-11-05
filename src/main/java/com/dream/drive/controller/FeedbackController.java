/*
 * package com.dream.drive.controller;
 * 
 * 
 * 
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.*;
 * 
 * import com.dream.drive.model.Feedback; import
 * com.dream.drive.repository.CarRepository; import
 * com.dream.drive.repository.FeedbackRepository;
 * 
 * @Controller public class FeedbackController {
 * 
 * @Autowired private FeedbackRepository feedbackRepository;
 * 
 * @Autowired private CarRepository carRepository;
 * 
 * @GetMapping("/feedback/{carId}") public String getFeedback(@PathVariable Long
 * carId, Model model) { model.addAttribute("car",
 * carRepository.findById(carId).orElse(null)); model.addAttribute("feedbacks",
 * feedbackRepository.findAll()); return "feedback"; }
 * 
 * @PostMapping("/addFeedback") public String addFeedback(@RequestParam String
 * username,
 * 
 * @RequestParam String comment,
 * 
 * @RequestParam int rating,
 * 
 * @RequestParam Long carId) { Feedback feedback = new Feedback();
 * feedback.setUsername(username); feedback.setComment(comment);
 * feedback.setRating(rating);
 * feedback.setCar(carRepository.findById(carId).orElse(null));
 * 
 * feedbackRepository.save(feedback);
 * 
 * return "redirect:/feedback/" + carId; } }
 * 
 */