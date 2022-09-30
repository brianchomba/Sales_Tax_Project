package com.brian.sales_tax;

import java.util.*; //importing all java.util classes
import java.text.DecimalFormat; //Adding decimal format from java.text.DecimalFormart class

/**
 *
 * @author brian
 */
public class Sales_Tax { //sales_tax class

    public static void main(String[] args) {
        
        ArrayList list = new ArrayList(); //creating an arraylist object 'list' to store items
        
        DecimalFormat df2 = new DecimalFormat("#.##"); //creating an instance object 'df2' to handle decimal places
        
        Scanner input = new Scanner(System.in); //creating an 'input' object to read from the keyboard
        
        int item_no = 1; // initializing item number variable
        while(true){
            
            Tax tax = new Tax(); //creating an instance of Tax class
            System.out.println("Add Item: " + item_no); //prompting the user to add Items
                                  
            System.out.print("Quantity: "); //reading items Quantity
            int qty = input.nextInt();
            tax.Qty = qty;
            
            System.out.print("Item Name: "); //reading items name
            String item = input.next();
            tax.itemdName = item;
            
            System.out.print("Price: "); //reading items price
            float p = input.nextFloat();
            tax.price = p;
            
            System.out.print("Is item Imported[y/n]: "); //checking if item is imported
            String imp = input.next();
            if (imp.toLowerCase().equals("y"))
                tax.imported = true;
            
            System.out.print("Is item Exempted[y/n]: "); //checking if Item is exempted from tax
            String exempted = input.next();
            if (exempted.toLowerCase().equals("y"))
                tax.exempted = true;
            
            tax.calculate_sale_tax(); //invoking calculating sales tax function
            
            list.add(tax); //adding Tax instance into an array list instance
            item_no++; //increamenting the item number
            
            System.out.print("Add More Items [y/n]: "); //prompting the user to add more items
            String add = input.next();
            if (add.toLowerCase().equals("n"))
                break;
                     
        }
        
        float total_price = 0.0f; //initializing total price variable
        float total_tax = 0.0f; //initializing total tax variable
        for (int i=0; i < list.size(); i++) { //defining a for-loop to iterate through the items
                   
            Tax tax = (Tax) list.get(i); //type casting list objects to Tax
            total_price += tax.price; //calculating total price
            total_tax += tax.tax; //calculating total tax
            
            System.out.println(tax); //printing out list of items purchased
            
        }
        
        System.out.println("Sales Taxes: " + df2.format(total_tax)); //print out total sales tax
        System.out.println("Total: " + df2.format(total_price + total_tax)); //print out total price + total tax
        
    }
}
