package com.hk.pricing.taxcalculator.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tech on 29/11/17.
 */
public class Cart implements Serializable{

    List<Product> products = new ArrayList<>();
    private BigDecimal totalCartValue;
    private BigDecimal totalTax;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public BigDecimal getTotalCartValue() {
        return totalCartValue;
    }

    public void setTotalCartValue(BigDecimal totalCartValue) {
        this.totalCartValue = totalCartValue;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }
}
