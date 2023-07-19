/*
* GrepRegEx.java
*
* Version:
*     $Id$: 4.0.2
*
* Revisions:
*     $Log$: 4.0.4
*/

import java.util.regex.*; 
import java.util.Scanner;
/**
* This program is about understanding and implementing
* the Pattern class in java and form regular expressions 
* to perform the following operations
* 
*
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/


public class GrepRegEx {
    /**
    * The main program.
    *
    * @param    args    command line arguments (ignored)
    */ 
    public static void main (String args[]){

        Scanner sc = new Scanner(System.in);
        //Take user input for the string which needs to be evaluated
        System.out.println("Enter the string: ");
        String Astring = sc.nextLine();
        //Operation 1: aeiou(correct), aeliowu(correct), aeilgou(incorrect)
        System.out.println("1. All vowels in order and non-vowels can be in between two vowels:");
        //Used subraction for consonants and '?' for 0 or 1 occurence
        System.out.println(Astring + " : " + Pattern.matches("a[a-z&&[^aeiou]]?e[a-z&&[^aeiou]]?i[a-z&&[^aeiou]]?o[a-z&&[^aeiou]]?u", Astring) );
        //Operation 2: abba(correct), aba(incorrect)
        System.out.println("2. 4 or 5 character palindrome:");

        if (Astring.length() == 4)
        {
            //length 4 palindrome
            //Used '\\2\\1' for back referencing 2nd and 1st capturing group
            System.out.println(Astring + " : " + Pattern.matches("(.)(.)\\2\\1", Astring) );
        }
        else if(Astring.length() == 5)
        {
            //length 5 palindrome
            //Used '\\2\\1' for back referencing 2nd and 1st capturing group
            System.out.println(Astring + " : " + Pattern.matches("(.)(.)(.)\\2\\1", Astring) );
        }
        else
        {
            System.out.println(Astring + " : false");
        }

        System.out.println("3. A palindrome between 1 and 30 characters long :");
        if (Astring.length() >= 1 && Astring.length() <= 30)
        {
            if (Astring.length() % 2 == 0)
            {
                // even length palindrome
                //Used '*' for 0 or more occurences and '+' for 1 or more occurences
                System.out.println(Astring + " : " + Pattern.matches("(.+)(.*)\\2\\1", Astring) );
            }
            else
            {
                //odd length palindrome
                //Used '*' for 0 or more occurences and '+' for 1 or more occurences
                System.out.println(Astring + " : " + Pattern.matches("(.*)(.*)(.)\\2\\1", Astring) );
            }
        }
        else
        {
            System.out.println(Astring + " : false");
        }

        System.out.println("4. 2 different date formats MM/DD/YY or DD/MM/YY :");
        //Used '|' opertor multiple times for all the possible date combinations excluding the April month
        System.out.println(Astring + " : " + Pattern.matches("((0[1[3][5-9]]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/[0-9][0-9])|((0[1-9]|[12][0-9]|3[01])/(0[1[3][5-9]]|1[0-2])/[0-9][0-9])|(02/(0[1-9]|1[0-9]|2[0-8])/[0-9][0-9])|((0[1-9]|1[0-9]|2[0-8])/02/[0-9][0-9])", Astring) );
        
        System.out.println("5. The text '[n-k](nl) where n,k and l are digits':");  
        //Used the concept of back referencing and capturing method as done above   
        System.out.println(Astring + " : " + Pattern.matches("\\[(\\d)\\-(\\d)\\]\\(\\1(\\d)\\)", Astring) );   
        sc.close();
    }

} // GrepRegEx.java