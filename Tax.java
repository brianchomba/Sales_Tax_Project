package com.brian.sales_tax;

/**
 *
 * @author brian
 */

//Create a Class Tax
public class Tax {
    
    //intializing instance variables
    String itemdName = null;
    int Qty = 0;
    float price = 0.0f;
    boolean imported = false;
    boolean exempted = false;
    float tax = 0.0f;
    
    //defining a caculating tax function
    void calculate_sale_tax(){
        
        //initializing variable to store totalTax
        float totalTax = 0.0f;
        
        //checking on item is imported
        if(imported)
            totalTax = 0.05f; //pass a tax of 5%
        
        //checking on item if its not exempetd from tax
        if (!exempted)
            totalTax = 0.1f; //pass a tax 10%
        
        //checking item if imported & not exempted
        if (imported && !exempted)
            totalTax = 0.15f; //pass a tax of 15%
        
        tax = totalTax * price; //calculating tax
                      
    }
    
    @Override
    public String toString(){
        float p = price + tax; //calculating total price plus tax
        
        return Qty + " " + itemdName + " at: " + p; //returning the item list
    }  
}
