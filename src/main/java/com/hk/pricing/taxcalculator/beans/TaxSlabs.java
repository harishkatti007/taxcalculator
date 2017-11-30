package com.hk.pricing.taxcalculator.beans;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tech on 29/11/17.
 */
/*Tax Slabs are used to store multiple slabs of taxes defined in the system*/
public class TaxSlabs {

    private static Map<String, BigDecimal> taxSlabs;

    private TaxSlabs(){}

    public static Map<String, BigDecimal> getTaxSlabs() {
        if(taxSlabs==null) {
            synchronized (TaxSlabs.class) {
                if(taxSlabs==null) {
                    taxSlabs = new ConcurrentHashMap<>();
                    populateTaxSlabs();
                }
            }
        }
        return taxSlabs;
    }

    private static void populateTaxSlabs() {
        taxSlabs.put("TS0", new BigDecimal(0.0));
        taxSlabs.put("TS1", new BigDecimal(5.0));
        taxSlabs.put("TS2", new BigDecimal(10.0));
        taxSlabs.put("TS3", new BigDecimal(17.5));
        taxSlabs.put("TS4", new BigDecimal(28.0));
        taxSlabs.put("TS5", new BigDecimal(1.25));
    }
}
