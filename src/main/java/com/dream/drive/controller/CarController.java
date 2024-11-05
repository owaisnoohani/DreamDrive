package com.dream.drive.controller;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.dream.drive.model.Car;
import com.dream.drive.service.CarService;

import java.io.IOException;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listCars", carService.getAllCars());
        return "index";
    }

    @GetMapping("/showNewCarForm")
    public String showNewCarForm(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "car-form";
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("car") Car car, @RequestParam("file") MultipartFile file) {
        try {
            // Check if a new file has been uploaded
            if (!file.isEmpty()) {
                // Update the image if a new file is uploaded
                car.setImage(file.getBytes());
            } else {
                // Keep the existing image if no new file is uploaded
                Car existingCar = carService.getCarById(car.getId());
                car.setImage(existingCar.getImage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        carService.saveCar(car);
        return "redirect:/"; // Redirect to the list of cars
    }


    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") long id, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "update_car"; // return the correct view name
    }

    @GetMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable("id") long id) {
        this.carService.deleteCarById(id);
        return "redirect:/";
    }
    @GetMapping("/carImage/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> getCarImage(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        if (car != null && car.getImage() != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Change this to the appropriate content type if you're using PNG, etc.
                    .body(car.getImage());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

/*@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
    	
        model.addAttribute(carService.getAllCars());
        
        return "index";
    }
  
    @GetMapping("/showCarForm")
    public String showCarForm(Model model) {
        model.addAttribute("car", new Car()); 
        return "car-form"; 
    }
    
    @GetMapping("/listCars")

    public String showCarsList(Model model) {
        model.addAttribute("car", carService.getAllCars()); 
        return "index"; 
    }
    
    @GetMapping("/carImage/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> getCarImage(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        if (car != null && car.getImage() != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Change this to the appropriate content type if you're using PNG, etc.
                    .body(car.getImage());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("car") Car car, @RequestParam("file") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                car.setImage(file.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        carService.saveCar(car);
        return "redirect:/listCars"; // Redirect to the list of cars
    }


    @GetMapping("/showFormForUpdate/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("car", car); // Make sure this is correct
        return "update_car"; // Return the update form
    }

    
    @GetMapping("/deleteCar/{id}")
    @PreAuthorize("hasRole('ADMIN')") // Ensure only admin can access this
    public String deleteCar(@PathVariable(value = "id") long id) {
        carService.deleteCarById(id);
        return "redirect:/listCars"; // Redirect to car list after deletion
    }
    
    }*/

