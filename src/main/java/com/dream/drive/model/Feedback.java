//package com.dream.drive.model;
//
//
//import jakarta.persistence.*;
//
//@Entity
//public class Feedback {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private Long carId;
//    private String comment;
//    private int rating;
//    private String username;
//
//    @ManyToOne
//    @JoinColumn(name = "car_id")
//    private Car car;
//    
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getCarId() {
//        return carId;
//    }
//
//    public void setCarId(Long carId) {
//        this.carId = carId;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    public int getRating() {
//        return rating;
//    }
//
//    public void setRating(int rating) {
//        this.rating = rating;
//    }
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public Car getCar() {
//		return car;
//	}
//
//	public void setCar(Car car) {
//		this.car = car;
//	}
//    
//}
