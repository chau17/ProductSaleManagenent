package com.example.product_management.entity;

import jakarta.persistence.*;

@Entity
public class SaleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_product_id")
    private Long saleProductId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "sale_percent")
    private double salePercent;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    public Long getSaleProductId() {
        return saleProductId;
    }

    public void setSaleProductId(Long saleProductId) {
        this.saleProductId = saleProductId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(double salePercent) {
        this.salePercent = salePercent;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}

