package com.example.product_management.repository;

import com.example.product_management.entity.Product;
import com.example.product_management.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {


    static List<Sale> findBySaleId(long saleId) {
        return null;
    }

    List<Sale> findBySaleNameContainingIgnoreCase(String saleName);


    List<Sale> findByDateBetween(LocalDate startOfMonth, LocalDate endOfMonth);

    List<Sale> findByDateBetween(Date startDate, Date endDate);
}