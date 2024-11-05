package com.dream.drive.service;

import com.dream.drive.model.Car;
import com.dream.drive.model.Sale;
import com.dream.drive.repository.CarRepository;
import com.dream.drive.repository.SaleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private SaleRepository saleRepository;

    public Sale sellCar(Long carId, String buyerName, String buyerEmail) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new EntityNotFoundException("Car not found"));

        car.setSold(true);
        carRepository.save(car);

        Sale sale = new Sale();
        sale.setCar(car);
        sale.setBuyerName(buyerName);
        sale.setBuyerEmail(buyerEmail);
        sale.setSaleDate(LocalDate.now());
        return saleRepository.save(sale);
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAllByOrderBySaleDateDesc();
    }
}

