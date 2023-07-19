/*
* SortedStorage.java
*
* Version:
*     $Id$: 4.0.1
*
* Revisions:
*     $Log$: 4.0.5
*/

import java.util.*;

/**
* The Sorted Storage class contains all the functions such as add,
* delete and find and stores the elements in a string containing "END"
* as the delimiter.
*
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/

public class SortedStorage {

    // Declaring and Initializing global variables
    public static String storeString = "";
    public static String delimString = "END";
    public static int counter = 0;
    public static String intmdString1;
    public static String intmdString2;
    public static String sortedString = "";
    public static char[] intmdarr = new char[10];


    /**
     * Remove the delimiters from the storage string and print the 
     * number of nulls and the values stored.
     *
     * @param    str         Storage string containing delimeters
     * @return   aString     String without delimeters
     */

    public static String toString1 (String str) {
        String aString = str.replaceAll("END",  "");
        System.out.println("");
        System.out.println(" Includes so many null values: " + counter);
        System.out.println(" Values stored: " + aString);
        return aString;
    }
    
    /**
     * Check if the storage string contains the value or not.
     *
     * @param    input       User input value
     * @return   boolean     True if the value is found, False otherwise
     */

    public static boolean toFind (String input) {
        // Check if null is present or not
        if(counter > 0){
            return true;
        }

        // Check if any other value is present or not
        if(storeString.contains(input) == true) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Add the user input value to the storage string.
     *
     * @param    input       User input value
     * @return   boolean     True if the value is added successfully, False otherwise
     */

    public static boolean add (String input) {
        sortedString = "";
        
        // Check if the string is empty and not equal to null
        if (storeString.isEmpty() == true && input != null) {
            storeString = delimString + input + delimString;
            return true;
        }

        // If input is null, just keep a counter to check the nymber of nulls
        if (input == null) {
            counter++;
            return true;
        }

        // Condition if the string is not empty. 
        if (storeString.isEmpty() == false) {
            
            // Check if the character is already present
            if (storeString.contains(input)) {
                return false;
            }

            // Condition if the character is not present in the storage
            else {
                intmdString1 = toString1(storeString);
                intmdString2 = intmdString1 + input;

                // Sorting the input before adding it back to the storage unit
                intmdarr = intmdString2.toCharArray();
                Arrays.sort(intmdarr);
                String tempString = String.copyValueOf(intmdarr);

                // Re-populating the storage unit 
                for (int index = 0; index<tempString.length(); index++) {
                    sortedString += delimString + tempString.charAt(index);
                }
                sortedString += delimString;
                storeString = sortedString;
                return true;
            }
        }
        return false;
    }

    /**
     * Delete the user input value from the storage string.
     *
     * @param    input       User input value
     * @return   boolean     True if the value is deleted successfully, False otherwise
     */
    public static boolean delete (String input){
        sortedString = "";
        
        // Check if the input is null
        if (input == null) {
            if (counter > 0) {
                counter--;
                return true;
            }
            else {
                return false;
            }
        }

        // Check if the input is present in the storage and it is not null
        else if(storeString.contains(input) == true && input != null){
            intmdString1 = toString1(storeString);
            intmdString2 = intmdString1.replace(input, "");
            for (int index = 0; index<intmdString2.length(); index++) {
                sortedString += delimString + intmdString2.charAt(index);
            }
            if (sortedString != ""){
                sortedString += delimString;
            }
            storeString = sortedString;
            return true;
        }
        
        return false;
    }

    /**
     * Function to check if the storage unit contains null
     *
     * @param    null
     * @return   boolean     True if storage contians null, False otherwise
     */
    public static boolean includesNull(){
        if(counter>0) {
            return true;
        }
        else {
            return false;
        }
    }
}