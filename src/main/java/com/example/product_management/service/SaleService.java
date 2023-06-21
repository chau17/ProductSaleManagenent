package com.example.product_management.service;

import com.example.product_management.entity.Product;
import com.example.product_management.entity.Sale;
import com.example.product_management.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class SaleService {
    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public static List<Sale> getSalesBySaleId(long saleId) {
        return SaleRepository.findBySaleId(saleId);
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }


    public List<Sale> getSalesForCurrentMonth() {
        LocalDate now = LocalDate.now();
        LocalDate startOfMonth = now.withDayOfMonth(1);
        LocalDate endOfMonth = now.withDayOfMonth(now.lengthOfMonth());
        return saleRepository.findByDateBetween(startOfMonth, endOfMonth);
    }

    public List<Sale> getSalesByPeriod(Date startDate, Date endDate) {
        if (startDate == null && endDate == null) {
            return saleRepository.findAll();
        } else {
            // Return sales within the specified date range
            return saleRepository.findByDateBetween(startDate, endDate);
        }
    }

    public Sale addSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale updateSale(Long saleId, Sale updatedSale) {
        Sale sale = saleRepository.findById(saleId).orElse(null);
        if (sale != null) {
            sale.setSaleName(updatedSale.getSaleName());
            sale.setStartDate(updatedSale.getStartDate());
            sale.setEndDate(updatedSale.getEndDate());
            return saleRepository.save(sale);
        }
        return null;
    }

    public void deleteSale(Long saleId) {
        saleRepository.deleteById(saleId);
    }

    public List<Sale> searchSalesByName(String saleName) {
        return saleRepository.findBySaleNameContainingIgnoreCase(saleName);
    }
}