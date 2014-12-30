package com.akosha.sales.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.akosha.sales.cart.ShoppingCart;
import com.akosha.sales.cart.ShoppingCartImpl;
import com.akosha.sales.helper.ItemHelper;

public class TestItem {

    ShoppingCart shoppingCart = new ShoppingCartImpl();
    
    ShoppingCart shoppingCart2 = new ShoppingCartImpl();
    
    @Test
    public void test() {
        Assert.assertEquals("Test for sales tax" , 6.70f ,shoppingCart.getSalesTax(), 0.0f );
    }
    
    @Test
    public void test2() {
        Assert.assertEquals("Test for sales tax" , 1.50f ,shoppingCart2.getSalesTax(), 0.0f );
    }
    
    @Before
    public void setData(){
        List<String> list = new ArrayList<String>();
        list.add("1 imported bottle of perfume at 27.99");
        list.add("1 bottle of perfume at 18.99");
        list.add("1 packet of headache pills at 9.75");
        list.add("1 box of imported chocolates at 11.25");
        ItemHelper.processReceiptData(list,shoppingCart);
        
        list.clear();
        list.add("1 book at 12.49");
        list.add("1 music CD at 14.99");
        list.add("1 chocolate bar at 0.85");
        ItemHelper.processReceiptData(list,shoppingCart2);
    }

}
