package Homework_7;

//Abstract Class Two : Bags (inherits the super concrete class Brand)
 abstract class Bags extends Brand {
    
    //Field Variables
    String bagMaterial;
    int length;
    int breadth;
    int height;

    //Constructor
    public Bags(String brandName,String bagMaterial,int length,int breadth,int height){
        super(brandName);
        this.bagMaterial = bagMaterial;
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    //Getter method for bagMaterial
    public String getBagMaterial(){
        return bagMaterial;
    }

    //Setter method for bagMaterial 
    public void setBagMaterial(){
        this.bagMaterial = bagMaterial;
    }

    //Getter method for length
    public int getLength(){
        return length;
    }

    //Setter method for length
    public void setLength(){
        this.length = length;
    }

    //Getter method for breadth
    public int getBreadth(){
        return breadth;
    }

    //Setter method for breadth
    public void setBreadth(){
        this.breadth = breadth;
    }

    //Getter method for height
    public int getHeight(){
        return height;
    }

    //Setter method for height
    public void setHeight(){
        this.height = height;
    }

    //Abstract Methods Declaration
    public abstract float bagSpace(int length, int breadth, int height);
    public abstract void bagWarranty();
    
}
