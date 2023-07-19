/*
* Hw_7_3.java
*
* Version:
*     $Id$: 7.3.2
*
* Revisions:
*     $Log$: 7.3.4
*/
package Homework_7;
/**
* This program is about understanding and implementing the 
* concept of inheritance, interface and abstract classes 
* to perform the following:
*
* Declare 4 concrete classes.
* 2 of these concrete classes should inherit from a common abstract class.
* The 2 other concrete classes should inherit from another common abstract class.
* Each abstract class should have at least one abstract method.
* The 2 abstract classes should have a common concrete class.
* Declare an interface that should have an abstract method. 
* The interface needs to be implemented by a few of the classes declares, nut must not be implemented by all.
*
*
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/
class Hw_7_3 {
// Main program
public static void main(String[] args) {
    
    // Created an object of class Chipotle
    Chipotle creamySauce = new Chipotle("Taco Bell","Spicy","Orange","12/08/22");
    // Getter method of super class Brand being called
    System.out.println("Brand Name: " + creamySauce.getBrandName());
    // This method is defined within the class Chipotle which has return type : void
    creamySauce.sauceQuantity();
    // Getter methods of abstract class Sauces being called in the following print statements  
    System.out.println("The type of sauce is " + creamySauce.getSauceType());
    System.out.println("The color of the sauce is " + creamySauce.getSauceColor());
    System.out.println("Date of purchase: " + creamySauce.getSaucePurchase());
    // This method is defined within the class Chipotle which has return type : void
    creamySauce.daysToExpire();

    System.out.println("\n -----------------------------------------------------\n");

    // Created an object of class Ranch
    Ranch classicSauce = new Ranch("Great Value","Sweet","White","26/09/22");
    // Getter method of super class Brand being called
    System.out.println("Brand Name: " + classicSauce.getBrandName());
    // This method is defined within the class Ranch which has return type : void
    classicSauce.sauceQuantity();
    // Getter methods of abstract class Sauces being called in the following print statements  
    System.out.println("The type of sauce is " + classicSauce.getSauceType());
    System.out.println("The color of the sauce is " + classicSauce.getSauceColor());
    System.out.println("Date of purchase: " + classicSauce.getSaucePurchase());
    // This method is defined within the class Ranch which has return type : void
    classicSauce.daysToExpire();
    
    System.out.println("\n -----------------------------------------------------\n");

    //Craeted an object of class BlueBag
    BlueBag blue = new BlueBag("SkyBags","Cloth", 100, 80, 30);
    // Getter method of super class Brand being called
    System.out.println("Brand Name: " + blue.getBrandName());
    // Getter methods of abstract class Bags being called in the following print statements  
    System.out.println("Bag Material type: " + blue.getBagMaterial());
    System.out.println("Dimensions of the bag: \n Length = " + blue.getLength() + " cms\n Breadth = " + blue.getBreadth() + " cms\n Height = " + blue.getHeight() + " cms");
    // This method returns a float value i.e volume of the bag
    System.out.println("Total Bag Space: " + blue.bagSpace(blue.length, blue.breadth, blue.height) + " cm^3");
    // This method is defined within the class BlueBag which has return type : void
    blue.bagWarranty();

    System.out.println("\n -----------------------------------------------------\n");

    // Created an object of class BlackBag
    BlackBag black = new BlackBag("American Tourister","Polypropylene", 120, 90, 50);
    // Getter method of super class Brand being called
    System.out.println("Brand Name: " + black.getBrandName());
    // Getter methods of abstract class Bags being called in the following print statements  
    System.out.println("Bag Material type: " +  black.getBagMaterial());
    System.out.println("Dimensions of the bag: \n Length = " + black.getLength() + " cms\n Breadth = " + black.getBreadth() + " cms\n Height = " + black.getHeight() + " cms");
    // This method returns a float value i.e volume of the bag
    System.out.println("Total Bag Space: " + black.bagSpace(black.length, black.breadth, black.height) + " cm^3");
    // This method is defined within the class BlackBag which has return type : void
    black.bagWarranty(); 
    }
}
// End of Main program