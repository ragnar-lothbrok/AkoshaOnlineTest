package com.akosha.sales.cart;

import com.akosha.sales.model.Item;

public interface ShoppingCart {

    public void addItemToCart(Item item);

    public void calculateTaxAndPrintReceiptWithTax();

    public float getSalesTax();

}
