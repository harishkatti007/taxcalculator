package com.hk.pricing.taxcalculator.service.impl;

import com.hk.pricing.taxcalculator.model.Product;
import com.hk.pricing.taxcalculator.service.TaxCategoryCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by tech on 30/11/17.
 */
public class TaxCategoryCalculatorServiceImplTest {

    @Test
    public void testProductValues1() {
        TaxCategoryCalculator taxCategoryCalculator = new TaxCategoryCalculatorImpl();
        Product product = new Product();

        product.setMrp(new BigDecimal(29.49));
        product.setSellingPrice(new BigDecimal(29.49));
        product.setQuantity(1);
        product.setProductCategory("Books");
        product.setProductDescription("Java fundamentals");
        product.setProductName("Core Java");

        Product product1 = taxCategoryCalculator.calculateTax(product);
        Assert.assertEquals(new BigDecimal(5.20).setScale(2, RoundingMode.DOWN), product1.getTax());
        Assert.assertEquals(new BigDecimal(34.69).setScale(2, RoundingMode.UP), product1.getTotalValue());
    }

    @Test
    public void testProductValues2() {
        TaxCategoryCalculator taxCategoryCalculator = new TaxCategoryCalculatorImpl();
        Product product1 = new Product();
        product1.setMrp(new BigDecimal(15.99));
        product1.setSellingPrice(new BigDecimal(15.99));
        product1.setQuantity(1);
        product1.setProductCategory("MusicCD");
        product1.setProductDescription("Music for soul");
        product1.setProductName("Soulful");

        Product product2 = taxCategoryCalculator.calculateTax(product1);
        Assert.assertEquals(new BigDecimal(4.05).setScale(2, RoundingMode.UP), product2.getTax());
        Assert.assertEquals(new BigDecimal(20.04).setScale(2, RoundingMode.UP), product2.getTotalValue());
    }

    @Test
    public void testProductValues3() {
        TaxCategoryCalculator taxCategoryCalculator = new TaxCategoryCalculatorImpl();
        Product product5 = new Product();
        product5.setMrp(new BigDecimal(4.15));
        product5.setSellingPrice(new BigDecimal(4.15));
        product5.setQuantity(1);
        product5.setProductCategory("Medicines");
        product5.setProductDescription("Tooth Ache Pill");
        product5.setProductName("Cipla");

        Product product2 = taxCategoryCalculator.calculateTax(product5);
        Assert.assertEquals(new BigDecimal(0.0).setScale(2, RoundingMode.UP), product2.getTax());
        Assert.assertEquals(new BigDecimal(4.15).setScale(2, RoundingMode.DOWN), product2.getTotalValue());
    }

}
