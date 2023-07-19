/*
* StoreEverythingSetWithNulls.java
*
* Version:
*     $Id$: 6.0.3
*
* Revisions:
*     $Log$: 6.0.7
*
* The Sorted Storage class contains all the functions for
* null element such as add,delete and find and stores the elements
* in a array of objects.
* 
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/
class StoreEverythingSetWithNulls extends StoreEverything{
    // Declaring and initializing variables
    boolean returnval;
    static int nullCounter = 0;


    /**
     * Delete Method: to delete objects from the object array
     *
     * @param    element     Any object 
     * @return   boolean     True if the value is deleted successfully, False otherwise
     */

    public boolean delete( Object element ) {
        // Check for deleting null element 
        if (element == null) {
            nullCounter--;
            return true;
        }
        this.returnval = super.delete(element);
        // Check for deleting all other objects
        if (this.returnval == false) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Find Method: To check whether a particular object is in the object array
     *
     * @param    element     Any object
     * @return   boolean     True if the value is found, False otherwise
     */

    public boolean find( Object element ) {
        // Check for finding null element
        if (nullCounter>0){
            return true;
        }
        // For finding all other objects
        super.find(element);
        return false;
    }

    /**
     * Add Method: To add an object to the object array
     *
     * @param    element     Any object
     * @return   boolean     True if the value is added successfully, False otherwise
     */

    public boolean add( Object element ) {
        // Check for adding null element in the object array
        if (element == null) {
            nullCounter++;
            return true;
        }
        // For adding elements in a set (no duplicates)
        for (int addIndex = 0; addIndex < this.arr.length; addIndex++ ) {
            if (this.arr[addIndex] == (element)) {
                return false;
            }
        }
        // For adding other objects in the set
        super.add(element);
        return true;
    }


     /**
     * ToString Method: Returns the string representation of null element
     *
     * @return   String      String of number of nulls in the array
     */

    public String toString() {
        return "Number of nulls: " + nullCounter;
    }

     /**
     * ToString Method: Returns the string representation of all objects 
     *
     * @return   Integer     returns the counter value for null elements
     */

    int howManyNulls() {
        return nullCounter;
    }
}
//StoreEverythingSetWithNulls.java