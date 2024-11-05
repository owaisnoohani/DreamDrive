package com.dream.drive.controller;

import com.dream.drive.model.Sale;
import com.dream.drive.repository.CarRepository;
import com.dream.drive.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private CarRepository carRepository;

    // Endpoint to show sold cars for admin updates
    @GetMapping("/sold-cars")
    public String viewSoldCarsForAdmin(Model model) {
        List<Sale> sales = saleService.getAllSales();
        model.addAttribute("sales", sales);
        return "admin/soldCarsAdmin"; // separate view for admin
    }

    // Endpoint to update car sale information
    @PostMapping("/update-sale")
    public String updateSale(@RequestParam Long saleId,
                             @RequestParam double newPrice,
                             @RequestParam String newBuyerName,
                             @RequestParam String newBuyerEmail, Model model) {
        Sale sale = saleService.updateSale(saleId, newPrice, newBuyerName, newBuyerEmail);
        return "redirect:/admin/sold-cars";
    }
}
