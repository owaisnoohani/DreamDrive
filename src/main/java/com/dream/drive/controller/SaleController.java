package com.dream.drive.controller;

import com.dream.drive.model.Sale;
import com.dream.drive.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
    @Controller public class SaleController {

        @Autowired
        private SaleService saleService;

        @GetMapping("/sold-cars")
        public String viewSoldCars(Model model) {
            List<Sale> sales = saleService.getAllSales();
            model.addAttribute("sales", sales);
            return "soldCars";
        }

        @PostMapping("/sell-car")
        public String sellCar(@RequestParam Long carId,
                              @RequestParam String buyerName,
                              @RequestParam String buyerEmail, Model model) {
            saleService.sellCar(carId, buyerName, buyerEmail);
            return "redirect:/sold-cars";
        }
    }
