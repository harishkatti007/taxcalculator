package com.hk.pricing.taxcalculator.service.impl;

import com.hk.pricing.taxcalculator.beans.TaxSlabs;
import com.hk.pricing.taxcalculator.beans.Taxation;
import com.hk.pricing.taxcalculator.model.Product;
import com.hk.pricing.taxcalculator.model.TaxComponent;
import com.hk.pricing.taxcalculator.service.TaxCategoryCalculator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

/**
 * Created by tech on 29/11/17.
 */
@Service
public class TaxCategoryCalculatorImpl implements TaxCategoryCalculator {
    @Override
    public Product calculateTax(Product product) {
        Map<String, List<TaxComponent>> taxation = Taxation.getTaxation();
        Map<String, BigDecimal> taxSlabs = TaxSlabs.getTaxSlabs();
        BigDecimal productTax = new BigDecimal(0.0);
        for(TaxComponent taxComponent: taxation.get(product.getProductCategory())) {
            if(taxComponent.getAbsolute()) {
                productTax = productTax.add(taxSlabs.get(taxComponent.getTaxSlab()));
            }
            if(!taxComponent.getAbsolute()) {
                BigDecimal sellingPrice = product.getSellingPrice();
                BigDecimal percentage = taxSlabs.get(taxComponent.getTaxSlab());
                percentage = percentage.divide(new BigDecimal(100.0));
                BigDecimal taxVal = sellingPrice.multiply(percentage);
                productTax = productTax.add(taxVal);
            }
        }
        productTax = productTax.multiply(new BigDecimal(product.getQuantity()));
        productTax = round(productTax, new BigDecimal(0.05), RoundingMode.UP);
        product.setTax(productTax);
        BigDecimal totalVal = product.getSellingPrice().multiply(new BigDecimal(product.getQuantity()));
        totalVal = totalVal.setScale(2, BigDecimal.ROUND_HALF_UP);
        product.setTotalValue(totalVal.add(productTax));
        return product;
    }

    public static BigDecimal round(BigDecimal value, BigDecimal increment,
                                   RoundingMode roundingMode) {
        if (increment.signum() == 0) {
            return value;
        } else {
            BigDecimal divided = value.divide(increment, 0, roundingMode);
            BigDecimal result = divided.multiply(increment);
            return result.setScale(2, RoundingMode.DOWN);
        }
    }
}
