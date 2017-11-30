package com.hk.pricing.taxcalculator.beans;

import com.hk.pricing.taxcalculator.model.Categories;
import com.hk.pricing.taxcalculator.model.TaxComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tech on 29/11/17.
 */
/*Singleton bean that is needed to store the category
 and tax components mapping which will be used for tax computation*/
public class Taxation {

    private static Map<String, List<TaxComponent>> taxation;

    public static Map<String, List<TaxComponent>> getTaxation() {
        if(taxation == null) {
            synchronized (Taxation.class) {
                if (taxation == null) {
                    taxation = new ConcurrentHashMap<>();
                    populateTaxation();
                }
            }
        }
        return taxation;
    }

    private Taxation() {
    }

    private static void populateTaxation() {
        List<TaxComponent> taxComponentList = new ArrayList<>();
        TaxComponent comp1 = new TaxComponent();
        comp1.setTaxCode("TC1");
        comp1.setTaxSlab("TS3");
        comp1.setAbsolute(false);
        taxComponentList.add(comp1);
        taxation.put(Categories.BOOKS.getName(), taxComponentList);
        taxation.put(Categories.CHOCOLATES.getName(), taxComponentList);
        taxation.put(Categories.ALCOHOL.getName(), taxComponentList);
        taxation.put(Categories.ACCESSORIES.getName(), taxComponentList);

        List<TaxComponent> taxComponentList2 = new ArrayList<>();
        TaxComponent comp2 = new TaxComponent();
        comp2.setTaxCode("TC1");
        comp2.setTaxSlab("TS5");
        comp2.setAbsolute(true);
        taxComponentList2.add(comp2);
        taxComponentList2.add(comp1);
        taxation.put(Categories.MUSIC_CD.getName(), taxComponentList2);


        TaxComponent comp3 = new TaxComponent();
        comp3.setTaxCode("TC1");
        comp3.setTaxSlab("TS0");
        comp3.setAbsolute(false);
        List<TaxComponent> taxComponentList3 = new ArrayList<>();
        taxComponentList3.add(comp3);
        taxation.put(Categories.MEDICINES.getName(), taxComponentList3);
    }


}
