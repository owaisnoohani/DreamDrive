package com.dream.drive.repository;

import com.dream.drive.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findAllByOrderBySaleDateDesc();
}