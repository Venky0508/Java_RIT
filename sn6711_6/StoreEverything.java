/*
* StoreEverything.java
*
* Version:
*     $Id$: 6.0.1
*
* Revisions:
*     $Log$: 6.0.5
*/
import java.util.*;
/**
* The Sorted Storage class contains all the functions such as add,
* delete and find and stores the elements in a array of objects.
* 
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/
public class StoreEverything{
    // Declaring and Initializing variables
    int index = 0;
    int hashIndex = 0;
    boolean flag = true;
    Object arr[] = new Object[10];
    int hashArr[] = new int[10];
    int hashValue; 
    int delHashValue;
    String res = "";
   
   
    /**
     * Delete Method: to delete objects from the object array
     *
     * @param    element     Any object 
     * @return   boolean     True if the value is deleted successfully, False otherwise
     */

    public boolean delete( Object element) {
        // Loop to go through all the objects within the array
        for (int index = 0; index < this.arr.length; index++) {
            // Check for the element we want to delete
            if (this.arr[index] == element) {
                this.arr[index] = null;
                this.delHashValue = System.identityHashCode(element);
                // Loop for deleting the element from the hashcode array
                for (int delIndex = 0; delIndex < this.hashArr.length; delIndex++) {
                    // Check for deleting the hashcode of the element from the array
                    if (this.hashArr[delIndex] == this.delHashValue) {
                        this.hashArr[delIndex] = 0;
                        break;
                    }
                } 
                return true;
            }
        }
        return false;
    }


     /**
     * Find Method: To check whether a particular object is in the object array
     *
     * @param    element     Any object
     * @return   boolean     True if the value is found, False otherwise
     */

	public boolean find(Object element)	{
        // For each loop to loop through all the objects within the array
        for (Object O : this.arr) {
            // Condition to check whether we have found a match within the object array
            if (element == O){
                return true;
            }
        }
		return false;
	}

    /**
     * Add Method: To add an object to the object array
     *
     * @param    element     Any object
     * @return   boolean     True if the value is added successfully, False otherwise
     */

	public boolean add(Object element)	{
        flag = true;
        // Adding each element to object array
        this.arr[this.index] = element;
        // Hashcode of each element
        this.hashValue = System.identityHashCode(element);
        // Adding hashcode of each element to a hashcode array
        this.hashArr[hashIndex] = this.hashValue;
        for (int newIndex = 0; newIndex < hashArr.length; newIndex++) {
            if (hashArr[newIndex] == 0) {
                flag = false;
                break;
            }
        }

        if (flag == true) {
            // Sorting the array on the basis of hashcode
            Arrays.sort(this.hashArr);
            //Loop for printing the array
            for (int newIndex = 0; newIndex < hashArr.length; newIndex++) {
                System.out.println(this.hashArr[newIndex]);
            }
        }
        index++;
        hashIndex++;
        return true;
	}

    /**
     * ToString Method: Returns the string representation of all objects 
     *
     * @return   String      String of all the objects in the hashcode array
     */

	public String toString()  {
        this.res = "";
        // Loop for traversing through the hashcode array
        for (int newIndex = 0; newIndex < hashArr.length; newIndex++) {
            // Condition for printing the hashcodes within the array
            if(hashArr[newIndex] == 0 && newIndex != hashArr.length) {
                continue;  
            }
            else {
                this.res += " " + this.hashArr[newIndex];
            } 
        }
        // Condition to check whether the array has any elements in it or not
        if (res.length() == 0) {
            return "No elements present.";
        }
        else {
            return "Hashcode representation of the elements: "+ res;
        }
    }
}
// StoreEverything.java