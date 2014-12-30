
package com.akosha.sales.service;

public class TaxCaculatorManager {
    
    private static TaxCalculatorService taxCalculatorService = new TaxCalculatorServiceImpl();
    
    private TaxCaculatorManager(){
        
    }
    
    public static TaxCalculatorService getInstance(){
        return taxCalculatorService;
    }
    
}
