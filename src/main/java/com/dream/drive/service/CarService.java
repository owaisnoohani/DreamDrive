package com.dream.drive.service;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.drive.model.Car;
import com.dream.drive.repository.CarRepository;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void saveCar(Car car) {
        carRepository.save(car);
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }
}
