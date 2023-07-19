package Homework_7;

//Concrete Class One: Ranch (inherits the abstract class Sauces and implements Expire interface)
 class Ranch extends Sauces implements Expire {

    //Constructor calls to the constructor of the abstract class: Sauces
    public Ranch(String brandName,String sauceType,String sauceColor,String saucePurchase){
        super(brandName,sauceType,sauceColor,saucePurchase);
    }

    //Abstract Method : sauceQuantity (from interface)
    public void sauceQuantity(){
        System.out.println("Quantity: 1.2 lbs");
    }

    //Abstract Method : daysToExpire (from interface)
    public void daysToExpire(){
        System.out.println("60 days for the sauce to expire.");
    }
}
