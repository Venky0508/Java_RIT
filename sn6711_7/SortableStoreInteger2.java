/*
* SortableStoreInteger2.java
*
* Version:
*     $Id$: 7.2.2
*
* Revisions:
*     $Log$: 7.2.3
*/

/**
 * The SortableStoreInteger2 class stores an Integer object.
 * 
 * @author Abhinav Ajit Menon
 * @author Srivenkatesh Shivadas Nair
 */
class SortableStoreInteger2 extends AbstractStorage2 implements SortableInterface{

    /**
     * Compare 2 objects to check which one is greater/smaller/equal.
     * 
     * @param x
     * @param y
     * @return int 1 if x>y,
     *             0 if x=y,
     *             -1 if x<y  
     */
    public int compareTo(Object x, Object y) {


        if(Integer.valueOf((Integer)x) > Integer.valueOf((Integer)y)) {
            return 1;
        }
        else if (Integer.valueOf((Integer)x) == Integer.valueOf((Integer)y)) {
            return 0;
        }
        else {
            return -1;
        }
    }

    /**
     * Sort the elements in the array.
     * 
     * @param null
     * @return void
     */   
    public void sort() {
        Object temp;
        int n = this.intArr.length;

        // Iterate over the objArr and maintain 2 indices for the current and the next element.
        for (int index1 = 0; index1 < n ; index1 ++ ){
            for (int index2 = 1 ; index2 < n - index1 - 1; index2++){

                // Check if any of the elements is null
                if (this.intArr[index2 - 1] != null && this.intArr[index2] != null) {
                    
                    // Compare the 2 elements by calling the compareTo function
                    if (compareTo(this.intArr[index2 - 1], this.intArr[index2]) == 1) {
                        
                        // Swap the elements
                        temp = this.intArr[index2 - 1];
                        this.intArr[index2-1] = this.intArr[index2];
                        this.intArr[index2] = (Integer)temp;
                    }
                }  
            }
        }
    }

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
            this.intArr[this.index] = (Integer)x;
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
        for (Object O : this.intArr) {
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
            for (int index = 0; index < this.intArr.length; index++) {
                // Check for the element we want to delete
                if (this.intArr[index] == x) {
                    this.intArr[index] = null;
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
        for (int sortIndex = 0; sortIndex < this.intArr.length - 1; sortIndex++ ){
            if (this.intArr[sortIndex] != null && this.intArr[sortIndex+1] != null) {
                if ( this.intArr[sortIndex].hashCode() > this.intArr[sortIndex + 1].hashCode()) {
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
        int temp = this.intArr.length;
        System.out.println("Hashcode of the elements:");

        // Iterate over the object array
        for (int index = 0; index < temp; index++) {
            if (this.intArr[index] == null) {
                continue;
            } else {
                // Concatenate the element to the string
                res += " " + this.intArr[index].hashCode();
            }
        }

        if (res.length() == 0) {
            return "No elements present.";
        } else {
            return res;
        }
    }
}
// SortableStoreInteger2.java