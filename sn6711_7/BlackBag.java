package Homework_7;

//Concrete Class Four : BlackBag (inherits the abstract class Bags) 
 class BlackBag extends Bags {
    
    //Constructor calls to the constructor of the abstract class: Bags
    public BlackBag(String brandName,String bagMaterial, int length, int breadth, int height){
        super(brandName,bagMaterial, length, breadth, height);
    }

    //Abstract Method : bagSpace (from abstract class) 
    public float bagSpace(int length, int breadth, int height){
        return length * breadth * height;
    }

    //Abstract Method : bagWarranty (from abstract class)
    public void bagWarranty(){
        System.out.println("This bag has a warranty period of 5 years.");
    }


}
