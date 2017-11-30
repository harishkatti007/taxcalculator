package com.hk.pricing.taxcalculator.service.impl;

import com.hk.pricing.taxcalculator.model.Cart;
import com.hk.pricing.taxcalculator.model.Product;
import com.hk.pricing.taxcalculator.service.TaxEngine;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tech on 30/11/17.
 */
public class TaxEngineImplTest {

    @Test
    public void testCartSalesTax() {
        TaxEngine taxEngine = new TaxEngineImpl();
        Cart cart = new Cart();
        List<Product> products = new ArrayList<>();
        Product product = new Product();

        product.setMrp(new BigDecimal(29.49));
        product.setSellingPrice(new BigDecimal(29.49));
        product.setQuantity(1);
        product.setProductCategory("Books");
        product.setProductDescription("Java fundamentals");
        product.setProductName("Core Java");
        products.add(product);

        Product product1 = new Product();
        product1.setMrp(new BigDecimal(15.99));
        product1.setSellingPrice(new BigDecimal(15.99));
        product1.setQuantity(1);
        product1.setProductCategory("MusicCD");
        product1.setProductDescription("Music for soul");
        product1.setProductName("Soulful");
        products.add(product1);

        Product product2 = new Product();
        product2.setMrp(new BigDecimal(0.75));
        product2.setSellingPrice(new BigDecimal(0.75));
        product2.setQuantity(1);
        product2.setProductCategory("Chocolates");
        product2.setProductDescription("Cadbury Chocolate");
        product2.setProductName("Dairy Milk");
        products.add(product2);

        cart.setProducts(products);
        Cart cart1 = taxEngine.calculateTax(cart);
        //Assert if the sales tax is as expected
        Assert.assertEquals(new BigDecimal(9.40).setScale(2, RoundingMode.DOWN), cart1.getTotalTax());
    }

    @Test
    public void testCartTotalValue(){
        TaxEngine taxEngine = new TaxEngineImpl();
        Cart cart = new Cart();
        List<Product> products = new ArrayList<>();
        Product product = new Product();

        product.setMrp(new BigDecimal(29.49));
        product.setSellingPrice(new BigDecimal(29.49));
        product.setQuantity(1);
        product.setProductCategory("Books");
        product.setProductDescription("Java fundamentals");
        product.setProductName("Core Java");
        products.add(product);

        Product product1 = new Product();
        product1.setMrp(new BigDecimal(15.99));
        product1.setSellingPrice(new BigDecimal(15.99));
        product1.setQuantity(1);
        product1.setProductCategory("MusicCD");
        product1.setProductDescription("Music for soul");
        product1.setProductName("Soulful");
        products.add(product1);

        Product product2 = new Product();
        product2.setMrp(new BigDecimal(0.75));
        product2.setSellingPrice(new BigDecimal(0.75));
        product2.setQuantity(1);
        product2.setProductCategory("Chocolates");
        product2.setProductDescription("Cadbury Chocolate");
        product2.setProductName("Dairy Milk");
        products.add(product2);

        cart.setProducts(products);
        Cart cart1 = taxEngine.calculateTax(cart);

        //Assert if the total value is as expected
        Assert.assertEquals(new BigDecimal(55.63).setScale(2, RoundingMode.DOWN), cart1.getTotalCartValue());
    }

    @Test
    public void testCartTotalValue1(){
        Cart cart2 = new Cart();
        List<Product> products1 = new ArrayList<>();
        Product product4 = new Product();

        product4.setMrp(new BigDecimal(20.99));
        product4.setSellingPrice(new BigDecimal(20.99));
        product4.setQuantity(1);
        product4.setProductCategory("Alcohol");
        product4.setProductDescription("Wine");
        product4.setProductName("Sula Wine");
        products1.add(product4);

        Product product5 = new Product();
        product5.setMrp(new BigDecimal(4.15));
        product5.setSellingPrice(new BigDecimal(4.15));
        product5.setQuantity(1);
        product5.setProductCategory("Medicines");
        product5.setProductDescription("Tooth Ache Pill");
        product5.setProductName("Cipla");
        products1.add(product5);

        Product product6 = new Product();
        product6.setMrp(new BigDecimal(14.99));
        product6.setSellingPrice(new BigDecimal(14.99));
        product6.setQuantity(1);
        product6.setProductCategory("MusicCD");
        product6.setProductDescription("Music for soul");
        product6.setProductName("Soulful");
        products1.add(product6);

        Product product7 = new Product();
        product7.setMrp(new BigDecimal(11.25));
        product7.setSellingPrice(new BigDecimal(11.25));
        product7.setQuantity(1);
        product7.setProductCategory("Accessories");
        product7.setProductDescription("Accessories");
        product7.setProductName("Pins");
        products1.add(product7);

        cart2.setProducts(products1);

        TaxEngine taxEngine1 = new TaxEngineImpl();
        Cart cart3 = taxEngine1.calculateTax(cart2);

        //Assert if the total value is as expected
        Assert.assertEquals(new BigDecimal(60.98).setScale(2, RoundingMode.UP), cart3.getTotalCartValue());
    }

    @Test
    public void testCartSalesTax1(){
        Cart cart2 = new Cart();
        List<Product> products1 = new ArrayList<>();
        Product product4 = new Product();

        product4.setMrp(new BigDecimal(20.99));
        product4.setSellingPrice(new BigDecimal(20.99));
        product4.setQuantity(1);
        product4.setProductCategory("Alcohol");
        product4.setProductDescription("Wine");
        product4.setProductName("Sula Wine");
        products1.add(product4);

        Product product5 = new Product();
        product5.setMrp(new BigDecimal(4.15));
        product5.setSellingPrice(new BigDecimal(4.15));
        product5.setQuantity(1);
        product5.setProductCategory("Medicines");
        product5.setProductDescription("Tooth Ache Pill");
        product5.setProductName("Cipla");
        products1.add(product5);

        Product product6 = new Product();
        product6.setMrp(new BigDecimal(14.99));
        product6.setSellingPrice(new BigDecimal(14.99));
        product6.setQuantity(1);
        product6.setProductCategory("MusicCD");
        product6.setProductDescription("Music for soul");
        product6.setProductName("Soulful");
        products1.add(product6);

        Product product7 = new Product();
        product7.setMrp(new BigDecimal(11.25));
        product7.setSellingPrice(new BigDecimal(11.25));
        product7.setQuantity(1);
        product7.setProductCategory("Accessories");
        product7.setProductDescription("Accessories");
        product7.setProductName("Pins");
        products1.add(product7);

        cart2.setProducts(products1);

        TaxEngine taxEngine1 = new TaxEngineImpl();
        Cart cart3 = taxEngine1.calculateTax(cart2);

        //Assert if the total value is as expected
        Assert.assertEquals(new BigDecimal(9.60).setScale(2, RoundingMode.UP), cart3.getTotalTax());
    }
}
