package com.akosha.sales.enums;

public enum TaxType {
    NO_TAX(0), BASIC_TAX(10.0f / 100), IMPORTED_TAX((5.0f / 100)), BOTH_TAX(BASIC_TAX.getTotalTax()
            + IMPORTED_TAX.getTotalTax());
    private float totalTax;

    private TaxType(float tax) {
        totalTax = tax;
    }

    public float getTotalTax() {
        return totalTax;
    }
}