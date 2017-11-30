package com.hk.pricing.taxcalculator.service.impl;

import com.hk.pricing.taxcalculator.model.Cart;
import com.hk.pricing.taxcalculator.model.Product;
import com.hk.pricing.taxcalculator.service.TaxCategoryCalculator;
import com.hk.pricing.taxcalculator.service.TaxEngine;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tech on 29/11/17.
 */
@Service
public class TaxEngineImpl implements TaxEngine {

    @Override
    public Cart calculateTax(Cart cart) {
        TaxCategoryCalculator taxCategoryCalculator = new TaxCategoryCalculatorImpl();
        BigDecimal cartTotalValue = new BigDecimal(0.0);
        BigDecimal totalTax = new BigDecimal(0.0);
        List<Product> products = new ArrayList<>();
        for(Product product: cart.getProducts()) {
            Product product1 = taxCategoryCalculator.calculateTax(product);
            products.add(product1);
            cartTotalValue = cartTotalValue.add(product1.getTotalValue());
            totalTax = totalTax.add(product1.getTax());
        }
        cart.setProducts(products);
        cart.setTotalCartValue(cartTotalValue);
        cart.setTotalTax(totalTax);
        return cart;
    }

    public static void main(String[] args) {
        //For Testing purposes only.
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

        TaxEngine taxEngine = new TaxEngineImpl();
        Cart cart1 = taxEngine.calculateTax(cart);

        for(Product product3: cart1.getProducts()) {
            System.out.println(product3.getQuantity() + " " + product3.getProductCategory() + " " + product3.getTotalValue());
        }
        System.out.println("Sales Tax: "+cart1.getTotalTax());
        System.out.println("Total: "+cart1.getTotalCartValue());


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

        for(Product product3: cart3.getProducts()) {
            System.out.println(product3.getQuantity() + " " + product3.getProductCategory() + " " + product3.getTotalValue());
        }
        System.out.println("Sales Tax: "+cart3.getTotalTax());
        System.out.println("Total: "+cart3.getTotalCartValue());

    }
}
