package com.akosha.sales.model;

import com.akosha.sales.enums.ItemType;
import com.akosha.sales.service.TaxCaculatorManager;

public class Item {
    private String itemDescription;
    private float itemPrice;
    private ItemType itemType;
    private float salesTax = -1.0f;

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public float getSalesTax() {
        if(salesTax == -1.0)
            salesTax =  TaxCaculatorManager.getInstance().calculateSalesTax(this);
        return salesTax;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice*1.00f;
    }

    public float getPriceWithSalesTax() {
        return getItemPrice() + getSalesTax();
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return getItemDescription() + "" + getPriceWithSalesTax();
    }
}
