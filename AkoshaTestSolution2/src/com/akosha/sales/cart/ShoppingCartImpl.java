package com.akosha.sales.cart;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;

import com.akosha.sales.model.Item;

public class ShoppingCartImpl implements ShoppingCart {

    private List<Item> itemList;
    private float saleTax;
    private float totalCost;
    private static final Format FORMATTER = new DecimalFormat("0.00");

    public ShoppingCartImpl() {
        itemList = new ArrayList<Item>();
    }

    @Override
    public void addItemToCart(Item item) {
        itemList.add(item);
    }

    @Override
    public void calculateTaxAndPrintReceiptWithTax() {
        StringBuilder buffer = new StringBuilder();
        for (Item item : itemList) {
            buffer.append("\n").append(item.toString());
            saleTax += item.getSalesTax();
            totalCost += item.getPriceWithSalesTax();
        }
        buffer.append("\nSales Tax:" + FORMATTER.format(saleTax));
        buffer.append("\nTotal :" + totalCost);
        System.out.println((buffer.length() > 0)?buffer.substring(1, buffer.length()).toString():"");
    }

    @Override
    public float getSalesTax() {
        return Float.valueOf(FORMATTER.format(saleTax));
    }

}
