package com.example.product_management.controller;

import com.example.product_management.entity.Sale;
import com.example.product_management.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {
    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }
    // Show sale list
    @GetMapping
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    // Show list of products on sale_id
   @GetMapping("sales/saleid")
   public List<Sale>getSalesBySaleId(@PathVariable long saleId){
        return SaleService.getSalesBySaleId(saleId);
   }

    // Show list of sale this month
    @GetMapping("/current-month")
    public List<Sale> getSalesForCurrentMonth() {
        return saleService.getSalesForCurrentMonth();
    }

    // Show a list of sales for an optional period of time
    @GetMapping("/sales-by-period")
    public List<Sale> getSalesByPeriod(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return saleService.getSalesByPeriod(startDate, endDate);
    }

    // Add new sale
    @PostMapping
    public Sale addSale(@RequestBody Sale sale) {
        return saleService.addSale(sale);
    }

    // Edit sale
    @PutMapping("/{saleId}")
    public Sale updateSale(@PathVariable Long saleId, @RequestBody Sale updatedSale) {
        return saleService.updateSale(saleId, updatedSale);
    }

    // Delete sale
    @DeleteMapping("/{saleId}")
    public void deleteSale(@PathVariable Long saleId) {
        saleService.deleteSale(saleId);
    }

    // Search by sale name
    @GetMapping("/search")
    public List<Sale> searchSalesByName(@RequestParam("saleName") String saleName) {
        return saleService.searchSalesByName(saleName);
    }
}