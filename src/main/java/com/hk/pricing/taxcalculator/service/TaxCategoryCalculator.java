package com.hk.pricing.taxcalculator.service;

import com.hk.pricing.taxcalculator.model.Product;

/**
 * Created by tech on 29/11/17.
 */
/*Tax category calculator provides an interface to calculate tax on the product level
* Tax category service is called from the tax engine by iterating over the products in the cart*/
public interface TaxCategoryCalculator {
    Product calculateTax(Product product);
}
