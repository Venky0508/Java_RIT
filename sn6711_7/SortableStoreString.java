/*
* SortableStoreString.java
*
* Version:
*     $Id$: 7.1.2
*
* Revisions:
*     $Log$: 7.1.3
*/

/**
 * The SortableStoreString class stores a string object.
 * 
 * @author Abhinav Ajit Menon
 * @author Srivenkatesh Shivadas Nair
 */

class SortableStoreString extends AbstractStorage {

    /**
     * Add a new element to the array
     * 
     * @param    x        Object to be added
     * @return boolean    True if the element was successfully added, false otherwise.
     */
    public boolean add(Object x) {

        // Check if the element to be added is null
        if (x == null) {
            nullCounter++;
            return true;
        }

        // Else add the element to the array
        else{
            this.strArr[this.index] = (String)x;
            index++;
            return true;
        }   
    }

    /**
     * Find the element in the array
     * 
     * @param    x       Object to be found
     * @return boolean   True if the element is found, false otherwise
     */
    public boolean find(Object x) {

        // Check if the element to be found is null
        if (nullCounter > 0){
            return true;
        }
        // For each loop to loop through all the objects within the array
        for (Object O : this.strArr) {
            // Condition to check whether we have found a match within the object array
            if (x == O) {
                return true;
            }
        }
        return false;
    }

    /**
     * Delete the element in the array
     * 
     * @param    x       Object to be deleted
     * @return boolean   True if the element is deleted, false otherwise
     */
    public boolean delete(Object x) {
        // Check for deleting null element 
        if (x == null) {
            nullCounter--;
            return true;
        }
        else{
            // Loop to go through all the objects within the array
            for (int index = 0; index < this.strArr.length; index++) {
                // Check for the element we want to delete
                if (this.strArr[index] == x) {
                    this.strArr[index] = null;
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Count the number of nulls
     * 
     * @param    null
     * @return   int   Returns the number of nulls
     */
    public int howManyNulls() {
        return nullCounter;
    }

    /**
     * Check if the elements are sorted in the array
     * 
     * @param   null
     * @return boolean   True if the elements are sorted, false otherwise
     */
    public boolean isSorted() {
        for (int sortIndex = 0; sortIndex < this.strArr.length - 1; sortIndex++ ){
            if (this.strArr[sortIndex+1] != null) {
                if ( this.strArr[sortIndex].hashCode() > this.strArr[sortIndex + 1].hashCode()) {
                    return false;
                }
            }  
        }
        return true;
    }

    /**
     * Represent the object as a String
     * 
     * @param   null
     * @return String   Returns a string representation of the object
     */
    public String toString() {
        String res = "";
        int temp = this.strArr.length;
        System.out.println("Hashcode of the elements:");

        // Iterate over the object array
        for (int index = 0; index < temp; index++) {
            if (this.strArr[index] == null) {
                continue;
            } else {
                // Concatenate the element to the string
                res += " " + this.strArr[index].hashCode();
            }
        }

        if (res.length() == 0) {
            return "No elements present.";
        } else {
            return res;
        }
    }
}
// SortableStoreString.java