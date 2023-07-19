/*
* Address.java
*
* Version:
*     $Id$: 9.0.1
*
* Revisions:
*     $Log$: 9.0.5
*/

/**
 * The Address class contains a cunstructor for initializing the values and overrides
 * the compareTo and toString functions
 * 
 * @author Abhinav Ajit Menon
 * @author Srivenkatesh Shivadas Nair
 */
public class Address implements Comparable<Address>{

    // Declaring instance variables
    int houseNumber; 
    String streetName; 
    String nameOfTown; 
    String state; 
    int zipCode;

    // Constructor
    public Address(int houseNumber, String streetName, String nameOfTown, String state, int zipCode){
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.nameOfTown = nameOfTown;
        this.state = state;
        this.zipCode = zipCode;
    }

    /**
     * ompareTo Method: to compare the hashcodes of 2 elements
     *
     * @param y An element of type LP
     * @return 1, -1, 0
     */

    @Override
    public int compareTo(Address y) {
        if(this.hashCode() > y.hashCode()) {
            return 1;
        }
        else if (this.hashCode() == y.hashCode()) {
            return 0;
        }
        else {
            return -1;
        }
    }

    /**
     * ToString Method: Returns the string representation of all objects
     *
     * @return String String of all the elements in the ArrayList
     */
    public String toString(){
        return "" + this.houseNumber + " " + this.streetName + " " + this.nameOfTown + " " + this.state + " " + this.zipCode;
    }
} // LP.java