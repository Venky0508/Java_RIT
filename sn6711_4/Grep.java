/*
* Grep.java
*
* Version:
*     $Id$: 4.0.1
*
* Revisions:
*     $Log$: 4.0.3
*/

import java.util.*;

/**
* The Grep program compares the user input with various patterns and checks if it
* matches with them or not.
*
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/

class Grep{
    static  Scanner sc= new Scanner(System.in);
    
    /**
     * Read an input from the user
     *
     * @param    null
     * @return   inputarr    Array of user input pattern
     */

    public static char[] userInput(){
        
        System.out.print("Enter the string pattern: ");
        String inputstr= sc.next();
        char[] inputarr = inputstr.toCharArray();
        return inputarr;
    }

    /**
     * Method for the following pattern:  ^ab$ 
     *
     * @param    charRepresentation   Array of user input pattern
     * @return   boolean              True of the user input matches the pattern, False otherwise
     */

    public static boolean ab (char[] charRepresentation) {
        int state = 0;
        for(int index = 0; index < charRepresentation.length; index ++) {
            if (state == 0) {
                
                // Check if the line starts with an 'a' 
                if (charRepresentation[index] == 'a') {
                    state = 1;
                    continue;
                }
                else {
                    state = 3;
                    return false;
                }
            }
                
            if(state == 1){

                // Check if the second character is 'b'
                if (charRepresentation[index] == 'b') {
                    return (index == charRepresentation.length -1);
                }
                else {
                    state = 3;
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Method for the following pattern: .ab. 
     *
     * @param    charRepresentation   Array of user input pattern
     * @return   boolean              True of the user input matches the pattern, False otherwise
     */

    public static boolean dotABDot (char[] charRepresentation) {
        int state = 0;
        for(int index = 0; index < charRepresentation.length; index ++) {
            
            // Accept any character for state 0
            if (state == 0) {
                state = 1;
                continue;
                }
            
            // Check if the second character is an 'a'
            if (state == 1){
                if(charRepresentation[index] == 'a') {
                    state = 2;
                    continue;
                }
                else {
                    return false;
                }
            }

            // Check if the third character is a 'b'
            if (state == 2) {
                if (charRepresentation[index] == 'b') {
                    state = 3;
                    continue;
                }
                else {
                    return false;
                }
            }

            // Accept any character for state 3
            if (state == 3) {
                return (index == charRepresentation.length -1);
            }   
        }
        return false;
    }
       
    /**
     * Method for the following pattern: .a+b. 
     *
     * @param    charRepresentation   Array of user input pattern
     * @return   boolean              True of the user input matches the pattern, False otherwise
     */

    public static boolean dotAplusBdot(char[] charRepresentation) {
        int state = 0;
        for (int index = 0; index < charRepresentation.length; index++) {
            
            // Accept any character for state 0
            if (state == 0) {
                state = 1;
                continue;
            }

            // Check if the second character is an 'a'
            if (state == 1) {
                if (charRepresentation[index] == 'a') {
                    state = 2;
                    continue;
                }
                else {
                    return false;
                }
            }

            // Accept any number of 'a's
            if(state == 2) {
                if (charRepresentation[index] == 'a') {
                    continue;
                }
                else {
                    state = 3;
                }
            }

            // Check if the next character is a 'b'
            if(state == 3) {
                if (charRepresentation[index] == 'b') {
                    state = 4;
                    continue;
                } 
                else {
                    return false;
                }
            }

            // Accept any character for state 4
            if(state == 4) {
                return (index == charRepresentation.length -1);
            }
        }
        return false;
    }

    /**
     * Method for the following pattern: ^[ab]c$ 
     *
     * @param    charRepresentation   Array of user input pattern
     * @return   boolean              True of the user input matches the pattern, False otherwise
     */

    public static boolean aORbANDc (char[] charRepresentation) {
        int state = 0;
        for(int index = 0; index < charRepresentation.length; index ++) {
            
            // Accept either 'a' or 'b'
            if (state == 0) {
                if (charRepresentation[index] == 'a' || charRepresentation[index] == 'b' ) {
                    state = 1;
                    continue;
                }
            }

            // Check if state 1 contains a 'c'
            if (state == 1) {
                if(charRepresentation[index] == 'c') {
                    return (index == charRepresentation.length -1);
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Method for the following pattern: ^[ab]?c$ 
     *
     * @param    charRepresentation   Array of user input pattern
     * @return   boolean              True of the user input matches the pattern, False otherwise
     */

    public static boolean aORbQc (char[] charRepresentation) {
        int state =0;
        for(int index = 0; index < charRepresentation.length; index ++){
            
            // Accept  either 'a' or 'b' for state 0
            if(state == 0) {
                if (charRepresentation[index] == 'a' || charRepresentation[index] == 'b'){
                    state = 1;
                    continue;
                }
                else if (charRepresentation[index] == 'c') {
                    return(index == charRepresentation.length -1);
                }
                else {
                    return false;
                }
            }
            
            // Accept character 'c' for state 1
            if(state == 1) {
                if (charRepresentation[index] == 'c'){
                    return (index == charRepresentation.length -1);
                }
                else{
                    return false;
                }
            }
        }
        return false;  
    }

    /**
     * Method for the following pattern: ^[ab]?c?$ 
     *
     * @param    charRepresentation   Array of user input pattern
     * @return   boolean              True of the user input matches the pattern, False otherwise
     */

    public static boolean aORbQORcQ (char[] charRepresentation) {
        int state = 0;
        for (int index = 0; index < charRepresentation.length; index ++) {
            
            // Accept 'a' or 'b' or 'c' for state 0
            if (state == 0) {
                if (charRepresentation[index] == 'a' || charRepresentation[index] == 'b' || charRepresentation[index] == 'c') {
                    if (index == charRepresentation.length - 1) {
                        return true;
                    }

                // Accept only 'a' or 'b'
                else if(charRepresentation[index] == 'a' || charRepresentation[index] == 'b'){
                    state = 1;
                    continue;
                }
                else {
                    return false;
                }
                }
            }

            // Accept only 'c' in state 1
            if (state == 1) {
                if(charRepresentation[index] == 'c') {
                    return (index == charRepresentation.length -1);
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Method for the following pattern: ^..\\2\\1$ 
     *
     * @param    charRepresentation   Array of user input pattern
     * @return   boolean              True of the user input matches the pattern, False otherwise
     */

    public static boolean palindrome (char[] charRepresentation) {
        int state = 0;
        char store1 = '#', store2 = '#';
        for (int index = 0; index < charRepresentation.length; index ++) {
            
            // Accept any character for state 0
            if(state == 0) {
                store1 = charRepresentation[index];
                state = 1;
                continue;
            }

            // Accept any character for state 1
            if(state == 1) {
                store2 = charRepresentation[index];
                state = 2;
                continue;
            }

            // Check if the third character matches with the second character
            if(state == 2) {
                if (charRepresentation[index] == store2) {
                    state = 3;
                    continue;
                }
                else {
                    return false;
                }
            }

            // Check if the fourth character matches with first character
            if(state == 3) {
                if(charRepresentation[index] == store1) {
                    return (index == charRepresentation.length -1);
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
    * The main program.
    *
    * @param    args    command line arguments (ignored)
    */
    public static void main(String[] args) {
        
        // Declaring and Initializing the variables
        boolean result;
        String exitString = "exit";
        String str;
        boolean flag = true;
        char[] word;

        while (flag == true){
            // Take the string from the user
            word = userInput();
            str = new String(word);
            
            if (str.equals(exitString)) {
                flag = false;
                break;
            }
            else {
                result = ab(word);
                if (result == true) {
                    System.out.println("Line: ^ab$  " + str);
                }

                result = dotABDot(word);
                if (result == true) {
                    System.out.println("Line: .ab.  " + str);
                }

                result = dotAplusBdot(word);
                if (result == true) {
                    System.out.println("Line: .a+b.  " + str);
                }

                result = aORbANDc(word);
                if(result == true) {
                    System.out.println("Line: ^[ab]c$  " + str);
                }

                result = aORbQc(word);
                if(result == true) {
                    System.out.println("Line: ^[ab]?c$  " + str);
                }

                result = aORbQORcQ(word);
                if(result == true) {
                    System.out.println("Line: ^[ab]?c?$  " + str);
                }

                result = palindrome(word);
                if(result == true) {
                    System.out.println("Line: ^..\\2\\1$  " + str);
                }
            }
        }
        sc.close();
    }  
} // Grep.java