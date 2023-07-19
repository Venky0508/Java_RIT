/*
* Test.java
*
* Version:
*     $Id$: 9.0.1
*
* Revisions:
*     $Log$: 9.0.5
*/
import java.util.* ;

/**
 * The Test method Creates and populates the ArrayLists, calls the sort function on them
 * and prints the ArrayLists
 * 
 * @author Abhinav Ajit Menon
 * @author Srivenkatesh Shivadas Nair
 */

public class Test {
    
    public static void main(String args[]) {

        // Create an ArrayList of type Address
        List<Address> aListOfAddresses 	= new ArrayList<Address>();

        // Create an ArrayList of type LP
        List<LP> aListOfLPs 		= new ArrayList<LP>();

        // Add the elements of the type Address into the ArrayList
        aListOfAddresses.add(  new Address(1600, "Pennsylvania Avenue NW", "Washington", "DC", 20500) );
        aListOfAddresses.add(  new Address(11, "Wall Street", "New York", "NY", 10118) );
        aListOfAddresses.add(  new Address(102, "Lomb Memorial Drive", "Rochester", "NY", 14623) );
        aListOfAddresses.add(  new Address(1, "A", "B", "C", 1) );
        aListOfAddresses.add(  new Address(2, "A", "B", "C", 1) );
        aListOfAddresses.add(  new Address(3, "A", "B", "C", 1) );
        aListOfAddresses.add(  new Address(4, "A", "B", "C", 1) );
        

        // Add the elements of the type LP into the ArrayList
        aListOfLPs.add( new LP( 1960, "Deep Purple in Rock", "Deep Purple", (float)43.30, 7));
        aListOfLPs.add( new LP( 1973, "Dark Side of the Moon", "Pink Floyd ", (float)43.09, 10));
        aListOfLPs.add( new LP( 1, "A", "B ", (float)3, 4));
        aListOfLPs.add( new LP( 2, "A", "B ", (float)3, 4));
        aListOfLPs.add( new LP( 3, "A", "B ", (float)3, 4));
        aListOfLPs.add( new LP( 0, "A", "B ", (float)3, 4));

        System.out.println(aListOfAddresses);
        System.out.println(aListOfLPs);

        // Sort the elements of the ArrayList
        Collections.sort(aListOfAddresses);
        Collections.sort(aListOfLPs);

        System.out.println(aListOfAddresses);
        System.out.println(aListOfLPs);
    }
} // Test.java
