package com.akosha.sales.service;

import com.akosha.sales.model.Item;

public interface TaxCalculatorService {
    float calculateSalesTax(Item item);
}
