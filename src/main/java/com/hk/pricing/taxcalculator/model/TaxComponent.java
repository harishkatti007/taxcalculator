package com.hk.pricing.taxcalculator.model;

import java.math.BigDecimal;

/**
 * Created by tech on 29/11/17.
 */
/*One category of a product can have multiple tax components defined*/
public class TaxComponent {

    private String taxCode;
    private String taxSlab;
    private Boolean absolute;

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getTaxSlab() {
        return taxSlab;
    }

    public void setTaxSlab(String taxSlab) {
        this.taxSlab = taxSlab;
    }

    public Boolean getAbsolute() {
        return absolute;
    }

    public void setAbsolute(Boolean absolute) {
        this.absolute = absolute;
    }
}
