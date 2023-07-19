/*
* SortableStoreString2.java
*
* Version:
*     $Id$: 7.2.2
*
* Revisions:
*     $Log$: 7.2.3
*/

/**
 * The SortableStoreString2 class stores a string object.
 * 
 * @author Abhinav Ajit Menon
 * @author Srivenkatesh Shivadas Nair
 */

class SortableStoreString2 extends AbstractStorage2  implements SortableInterface{

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
        String word1=(String)x;
        charArr1 = word1.toCharArray();
        String word2=(String)y;
        charArr2 = word2.toCharArray();

        // Iterate over the array and maintain 2 indices.
        for (int index1 = 0, index2 = 0; index1 < word1.length() && index2 < word2.length(); index1++, index2++) {
            if(charArr1[index1] > charArr2[index2]) {
                return 1;
            }
            else if(charArr1[index1] == charArr2[index2]) {
                return 0;
            }
            else {
                return -1;
            }
        }
        return -1;
    }
    
    /**
     * Sort the elements in the array.
     * 
     * @param null
     * @return void
     */
    public void sort() {
        Object temp;
        int n = this.strArr.length;

        // Iterate over the array and maintain 2 indices.
        for (int index1 = 0; index1 < n ; index1 ++ ){
            for (int index2 = 1 ; index2 < n - index1; index2++){

                // Check if the element is null
                if (this.strArr[index2 - 1] != null && this.strArr[index2] != null){

                    // Compare the 2 elements by calling the compareTo function 
                    if (compareTo(this.strArr[index2 - 1], this.strArr[index2]) == 1) {
                        
                        // Swap the elements
                        temp = this.strArr[index2 - 1];
                        this.strArr[index2-1] = this.strArr[index2];
                        this.strArr[index2] = (String)temp;
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
        boolean flag = false;

        // Iterate over the array
        for (int sortIndex = 0; sortIndex < this.strArr.length - 1; sortIndex++ ){
            
            //  Check if the element is null
            if (this.strArr[sortIndex] != null && this.strArr[sortIndex + 1] != null) {
                String isSortWord1=(String)strArr[sortIndex];
                isSortArr1 = isSortWord1.toCharArray();
                String isSortWord2=(String)strArr[sortIndex + 1];
                isSortArr2 = isSortWord2.toCharArray();

                // Iterate over the 2 char arrays maintaining 2 indices
                for (int index1 = 0, index2 = 0; index1 < isSortWord1.length() && index2 < isSortWord2.length(); index1++, index2++) {
                    
                    // Check if the characters are equal or character in the first array is smaller
                    if (isSortArr1[index1] == isSortArr2[index2] || isSortArr1[index1] < isSortArr2[index2]) {
                        flag = true;;
                    }

                    // Check if the character in the first array is larger
                    if(isSortArr1[index1] > isSortArr2[index2]) {
                        flag = false;
                    }
                }
            }  
        }
        return flag;
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
        
        // Iterate over the object array
        for (int index = 0; index < temp; index++) {
            if (this.strArr[index] == null) {
                continue;
            } else {
                // Concatenate the element to the string
                res += " " + this.strArr[index];
            }
        }

        if (res.length() == 0) {
            return "No elements present.";
        } else {
            return res;
        }
    }
}
// SortableStoreString2.java