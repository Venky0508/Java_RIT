/*
* Word.java
*
* Version:
*     $Id$: 5.0.2
*
* Revisions:
*     $Log$: 5.0.1
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* The Word class reads the target words from a file
* and accepts user input.
*
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/


public class Word {
    
    /**
     * Read words from a text file
     *
     * @param    counter    keeps track of the player number
     * @return   ch1        first word in the file
     * @return   ch2        second word in the file
     * @return   invalid    invalid read
     */

    public static char [] readfromfile(int counter) throws FileNotFoundException {
        File test = new File("D:\\Abhinav\\Master's CS\\Sem 1\\Advanced Object Oriented Programming\\hw 5\\hw 5.2\\Classes\\src\\words.txt");
        Scanner sc = new Scanner(test);
       
        char[] ch1 = new char[2];
        char[] ch2 = new char[2];
        char [] invalid = {'o'};
        while (sc.hasNextLine() == true)
        {   
            // Return word for player 1
            if(counter == 1)
            {
                String line1 = sc.nextLine();
                ch1 = line1.toCharArray();
                return ch1;
            }
            
            // Return word for player 2
            else if(counter == 2)
            {
                String line2 = sc.nextLine();
                String line3 = sc.nextLine();
    
                ch2 = line3.toCharArray();
                return ch2;
            }
            sc.close();
        }
        return invalid;
    }


    /**
     * Read the user's guess 
     *
     * @param    void
     * @return   guess   user entered character    
     */

    public static char readUserInput() {
        Scanner sc = new Scanner(System.in);   
        char guess = sc.next().charAt(0);
        return guess;
    }
}
