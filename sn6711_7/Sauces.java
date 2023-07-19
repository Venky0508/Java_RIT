package Homework_7;

//Abstract Class One: Sauces (inherits the super concrete class Brand)
 abstract class Sauces extends Brand{

    //Field variables
    String sauceType;
    String sauceColor;
    String saucePurchase;

    //Constructor
    public Sauces(String brandName, String sauceType,String sauceColor,String saucePurchase){
        super(brandName);
        this.sauceType = sauceType;
        this.sauceColor = sauceColor;
        this.saucePurchase = saucePurchase;
    }

    //Getter method for sauceType
    public String getSauceType(){
        return sauceType;
    }

    //Setter method for sauceType
    public void setSauceType(String sauceType){
        this.sauceType = sauceType;
    }

    //Getter method for sauceColor
    public String getSauceColor(){
        return sauceColor;
    }

    //Setter method for sauceColor
    public void setSauceColor(String sauceColor){
        this.sauceColor = sauceColor;
    }

    //Getter method for saucePurchase
    public String getSaucePurchase(){
        return saucePurchase;
    }

    //Setter method for saucePurchase
    public void setSaucePurchase(String saucePurchase){
        this.saucePurchase = "[0-9][1-9]/[0-9][1-9]/[0-9][0-9]";
    }
}
