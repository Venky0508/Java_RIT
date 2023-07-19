/*
* SortedStorage.java
*
* Version:
*     $Id$: 8.0.1
*
* Revisions:
*     $Log$: 8.0.5
*/

/**
* The Sorted Storage class contains all the functions such as add,
* delete and find and stores the elements in an array of generic type.
* 
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/


public class SortedStorage<E extends Comparable<E>> implements StorageInterface<E>, Comparable<E>{
    // Declaring and Initializing variables
    int index = 0;
    E[] arr = (E[])new Comparable[10];
    int nullCounter = 0;
    String res = "";
   
    /**
     * includesNull Method: check if there are any nulls present
     *
     * @return   boolean     True if nulls are present, False otherwise
     */

    public boolean includesNull() {
        if(this.nullCounter > 0) {
            return true;
        }
        else{
            return false;
        }
    }
   
    /**
     * Delete Method: to delete objects from the object array
     *
     * @param    element     Any object 
     * @return   boolean     True if the value is deleted successfully, False otherwise
     */

    public boolean delete( E element) {
        // Check for deleting null element 
        if (element == null) {
            this.nullCounter--;
            return true;
        }
        else{
            // Loop to go through all the objects within the array
            for (int index = 0; index < this.arr.length; index++) {
                // Check for the element we want to delete
                if (this.arr[index] == element) {
                    this.arr[index] = null;
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Find Method: To check whether a particular object is in the object array
     *
     * @param    element     Any object
     * @return   boolean     True if the value is found, False otherwise
     */

	public boolean find(E element)	{
        if (this.nullCounter > 0){
            return true;
        }
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
     * ompareTo Method: to compare the hashcodes of 2 elements
     *
     * @param y An element of type LP
     * @return 1, -1, 0
     */
    @Override
    public int compareTo(E y) {
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
     * sort Method: Sort the elemnts that are in the array
     *
     * @param    None      
     * @return   void     
     */

    public void sort (){
        E temp;
        int n = this.arr.length;
        // Loop for going through all the elements within the array
        for (int index1 = 0; index1 < n ; index1 ++ ){
            for (int index2 = 1 ; index2 < n - index1; index2++){
                // Condition to check whether the elements are not null
                if(this.arr[index2-1] != null && this.arr[index2] != null) {
                    // Sorting the elements on the basis of hashcodes
                    if (this.arr[index2-1].hashCode() > this.arr[index2].hashCode()){
                        // Swapping the elements in the array
                        temp = this.arr[index2 - 1];
                        this.arr[index2-1] = this.arr[index2];
                        this.arr[index2] = temp;
                    }
                }
            }
        }  
    }

    /**
     * Add Method: To add an object to the object array
     *
     * @param    element     Any object
     * @return   boolean     True if the value is added successfully, False otherwise
     */

	public boolean add(E element)	{
        // Adding each element to object array
        if (element == null) {
            this.nullCounter++;
            return true;
        }

        for (int addIndex = 0; addIndex < this.arr.length; addIndex++ ) {
            // Conditions to avoid adding duplicate values
            if (this.arr[addIndex] != null && element != null && this.arr[addIndex].hashCode() == element.hashCode()) {
                return false;
            }
        }
        // For adding elements in a set
        this.arr[this.index] = element;
        sort();
        this.index++;
        return true;  
        
	}

    /**
     * ToString Method: Returns the string representation of all objects 
     *
     * @return   String      String of all the objects in the hashcode array
     */

	public String toString()  {
        this.res = "";
        // Loop for traversing through the  array
        for (int newIndex = 0; newIndex < this.arr.length; newIndex++) {
            // Condition for printing the hashcodes of the elements within the array
            if(this.arr[newIndex] == null && newIndex != this.arr.length) {
                continue;  
            }
            else {
                this.res += " " + this.arr[newIndex].hashCode();
            } 
        }
        // Condition to check whether the array has any elements in it
        if (res.length() == 0) {
            return "No elements present.";
        }
        else {
            return "Hashcode representation of the elements: "+ res;
        }
    }
}
// SortedStorage.java