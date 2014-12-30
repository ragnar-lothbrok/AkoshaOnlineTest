package com.akosha.sales.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.akosha.sales.cart.ShoppingCart;
import com.akosha.sales.cart.ShoppingCartImpl;
import com.akosha.sales.enums.ItemType;
import com.akosha.sales.model.Item;

public class ItemHelper {
    
    public static Item createItem(String itemDescription){
        Item item = new Item();
        String tokens[] = itemDescription.split(" ");
        boolean isExemptedItem = false;
        boolean isImportedItem = false;
        if(itemDescription.toLowerCase().contains("book") 
                || itemDescription.toLowerCase().contains("pill")
                ||itemDescription.toLowerCase().contains("medical")
                || itemDescription.toLowerCase().contains("food")
                || itemDescription.toLowerCase().contains("chocolate")
                ){
            isExemptedItem = true;
        }
        if(itemDescription.toLowerCase().contains("imported")){
            isImportedItem = true;
        }
        
        if(isImportedItem && isExemptedItem){
            item.setItemType(ItemType.IMPORTED_EXEMPTED);
        }else if(!isImportedItem && isExemptedItem){
            item.setItemType(ItemType.EXEMPTED);
        }else if(isImportedItem && !isExemptedItem){
            item.setItemType(ItemType.IMPORTED_OTHERS); 
        }else if(!isImportedItem && !isExemptedItem){
            item.setItemType(ItemType.OTHERS);
        }
        item.setItemPrice(Float.parseFloat(tokens[tokens.length-1]));
        item.setItemDescription(itemDescription.replace(" at", ":").replace(tokens[tokens.length-1], ""));
        return item;
    }
    
    public static void processReceiptData(List<String> itemsList,ShoppingCart shoppingCart){
        try{
            if(shoppingCart == null)
                shoppingCart = new ShoppingCartImpl();
            if(itemsList.size() > 0){
                for(String item : itemsList){
                    shoppingCart.addItemToCart(createItem(item));
                }
            }
            shoppingCart.calculateTaxAndPrintReceiptWithTax();
        }catch(Exception exception){
            System.out.println("Exception occured : "+exception.getStackTrace());
        }
        
    }
    
    public static void processReceipt(){
        List<String> itemsList = null;
        BufferedReader bufferedReader = null;
        try{
            bufferedReader = new BufferedReader(new FileReader("/home/pubmatic/FinalAdNetworkPlacementChanges/AkoshaTest/src/input.txt"));
            String itemDec = bufferedReader.readLine();
            while(itemDec != null && itemDec.trim().length() > 0){
                if(itemsList == null)
                    itemsList = new ArrayList<String>();
                itemsList.add(itemDec);
                itemDec = bufferedReader.readLine();
            }
            ShoppingCart shoppingCart = new ShoppingCartImpl();
            processReceiptData(itemsList,shoppingCart);
        }catch(Exception exception){
            System.out.println("Exception occured : "+exception.getStackTrace());
        }finally{
            try {
                bufferedReader.close();
            } catch (Exception exception) {
                System.out.println("Exception occured while closing stream : "+exception.getStackTrace());
            }
        }
        
    }
    
}
