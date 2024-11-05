//package com.dream.drive.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.dream.drive.model.Feedback;
//import com.dream.drive.repository.FeedbackRepository;
//
//import java.util.List;
//
//@Service
//public class FeedbackService {
//
//    @Autowired
//    private FeedbackRepository feedbackRepository;
//
//    public List<Feedback> getAllFeedbacks() {
//        return feedbackRepository.findAll();
//    }
//
//    public Feedback saveFeedback(Feedback feedback) {
//        return feedbackRepository.save(feedback);
//    }
//}
