package com.hk.pricing.taxcalculator.service;

import com.hk.pricing.taxcalculator.model.Cart;

/**
 * Created by tech on 29/11/17.
 */
/*Tax Engine provides an interface to calculate the tax on the user cart*/
public interface TaxEngine {

    Cart calculateTax(Cart cart);
}
