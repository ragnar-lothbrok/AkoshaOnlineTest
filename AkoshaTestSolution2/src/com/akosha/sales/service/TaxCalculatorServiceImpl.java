package com.akosha.sales.service;

import com.akosha.sales.enums.TaxType;
import com.akosha.sales.model.Item;

public class TaxCalculatorServiceImpl implements TaxCalculatorService {

    private static final float ROUNDOFF = 0.05f;

    @Override
    public float calculateSalesTax(Item item) {
        return roundOffTax(getItemTaxType(item).getTotalTax() * item.getItemPrice());
    }

    private TaxType getItemTaxType(Item item) {
        if (item.getItemType().isImported() && !item.getItemType().isExempted()) {
            return TaxType.BOTH_TAX;
        } else if (item.getItemType().isImported() && item.getItemType().isExempted()) {
            return TaxType.IMPORTED_TAX;
        } else if (!item.getItemType().isImported() && !item.getItemType().isExempted()) {
            return TaxType.BASIC_TAX;
        }
        return TaxType.NO_TAX;
    }

    private float roundOffTax(double tax) {
        return (float) Math.ceil(tax / ROUNDOFF) * ROUNDOFF;
    }

}
