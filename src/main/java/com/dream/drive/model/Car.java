package com.dream.drive.model;

import jakarta.persistence.*;

@Entity
public class Car {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;
    private String model;
    
    @Column(name = "\"year\"")
    private int year;
    
    private double price;

	private boolean sold;

    @Lob
    private byte[] image;

    // Constructors, getters, and setters
    public Car() {}

    public Car(String make, String model, int year, double price, byte[] image, boolean sold) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.image = image;
		this.sold= sold;
    }

    // Getters and setters
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}
}
