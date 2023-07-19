/*
* StringIntegerArrays.java
*
* Version:
*     $Id$: 3.0.1
*
* Revisions:
*     $Log$: 3.0.7
*/

import java.util.Arrays;

/**
* This program is about understanding and implementing
* the built-in methods of String, Integer and Array 
* class to perform the following operations
* 
*
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/

public class StringIntegerArrays {

    /**
    * The main program.
    *
    * @param    args    command line arguments (ignored)
    */ 
    public static void main (String [] args)
    {
        
        if ( args.length == 1 )
         {
            String aString = "123425" + "25";
            String bString = "12342525";
            String cString = "5";
            String dString = "25" + "2" + cString;
            String eString = "a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z";
            String fString = "A, B, C, D, E, F, G, H, I, J, K, *, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z";
            String gString = aString + ( bString + cString ) + dString;
            String hString = "2525" +  "+" + "2525";
            String iString = "2525+2525";

            /*
             * To check whether two strings are identical 
             * i.e  we need to compare the objects:
             * To compare objects we use "==" operator
             * 
             * To check whether two strings are equal
             * we use the .equals() method in String Class:
             * It check whether all the characters are same 
             * and in the same sequence in both strings. 
             */
            System.out.println("I. aString and bString are identical:" + (aString == bString));
            System.out.println("II. aString and dString are identical:" + (aString == dString));
            System.out.println("III. aString and bString are equal:" + (aString.equals(bString)));
            System.out.println("IV. hString and iString are identical:" + (hString == iString));
            System.out.println("V. hString and iString are equal:" + (hString.equals(iString)));
            System.out.println("VI. aString and dString are equal:" + (aString.equals(dString)));

            /*
             * .decode() is a method of the Integer Class:
             * It decodes a string into integer
             * .toString() is a method of the String Class:
             * It converts an object which was a string 
             * again into a string.
             * .substring() is a method of the String Class:
             * This method returns a substring of 
             * the original string.
             * .parseInt() is a method of the Integer Class:
             * It parses a string to a signed decimal integer
             */
            Integer number1 = Integer.decode(aString);
            String x1_String = Integer.toString(number1).substring(0, 1);
            String x2_String = Integer.toString(number1).substring(1, 2);
            int firstDigit = Integer.parseInt(x1_String);
            int secondDigit = Integer.parseInt(x2_String);
            String extract1 = dString.substring(firstDigit,(secondDigit+1));
            System.out.println("VII. Extract from dString the string starting at the number defined by the first digit in aString to defined by the digit at the second in aString: " + extract1);                                        
            
            /*
             * .indexOf() is a method of String Class:
             * It return the index of a string element
             * .charAt() is a method of String Class:
             * It returns the string or character at 
             * that particular index
             */
            int index2 = fString.indexOf("*");
            char extract2 = eString.charAt(index2);
            System.out.println("VIII. Extract the character of eString, which is at the position of * on fString: " + extract2);
            
            /*
             * .decode() is a method of the Integer Class:
             * It decodes a string into integer
             * .toString() is a method of the String Class:
             * It converts an object which was a string 
             * again into a string.
             * .chars() is a method of the String Class:
             * Get a stream of int that represents the 
             * ASCII value of each char(~digit) composing 
             * the String version of our integer.
             * .map(c -> c-'0') method converts the ASCII value
             * of each character to its value.
             * .toArray method converts string to integer array.
             * 
             */

            Integer number2 = Integer.decode(bString);
            int[] digits = Integer.toString(number2).chars().map(c -> c-'0').toArray();
            int end = digits.length;
            Arrays.sort(digits, 0, end);
            System.out.println("IX. Sorted bString: " + Arrays.toString(digits));
        } 
        else {

            
            String aString = "12342" + new String("" + 5) +  "25";
            String bString = "12342525";
            String cString = "5";
            String dString = "" + "25" + "" + "2" + cString;
            String eString = "b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z";
            String fString = "B, C, D, E, F, G, H, I, J, K, *, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z";
            String gString = ( ( aString + bString )  + "" + 5 ) + dString;
            String hString = "2525" +  "+" + "2525";
            String iString = "25" + ( 2 + 5 ) + "+2525";

           /*
             * To check whether two strings are identical 
             * i.e  we need to compare the objects:
             * To compare objects we use "==" operator
             * 
             * To check whether two strings are equal
             * we use the .equals() method in String Class:
             * It check whether all the characters are same 
             * and in the same sequence in both strings. 
             */

            System.out.println("I. aString and bString are identical:" + (aString == bString));
            System.out.println("II. aString and dString are identical:" + (aString == dString));
            System.out.println("III. aString and bString are equal:" + (aString.equals(bString)));
            System.out.println("IV. hString and iString are identical:" + (hString == iString));
            System.out.println("V. hString and iString are equal:" + (hString.equals(iString)));
            System.out.println("VI. aString and dString are equal:" + (aString.equals(dString)));
            
             /*
             * .decode() is a method of the Integer Class:
             * It decodes a string into integer
             * .toString() is a method of the String Class:
             * It converts an object which was a string 
             * again into a string.
             * .substring() is a method of the String Class:
             * This method returns a substring of 
             * the original string.
             * .parseInt() is a method of the Integer Class:
             * It parses a string to a signed decimal integer
             */

            Integer number1 = Integer.decode(aString);
            String x1_String = Integer.toString(number1).substring(0, 1);
            String x2_String = Integer.toString(number1).substring(1, 2);
            int firstDigit = Integer.parseInt(x1_String);
            int secondDigit = Integer.parseInt(x2_String);
            String extract1 = dString.substring(firstDigit,(secondDigit+1));
            System.out.println("VII. Extract from dString the string starting at the number defined by the first digit in aString to defined by the digit at the second in aString: " + extract1);
            
             /*
             * .indexOf() is a method of String Class:
             * It return the index of a string element
             * .charAt() is a method of String Class:
             * It returns the string or character at 
             * that particular index
             */

            int index = fString.indexOf("*");
            char extract2 = eString.charAt(index);
            System.out.println("VIII. Extract the character of eString, which is at the position of * on fString: " + extract2);
            
            /*
             * .decode() is a method of the Integer Class:
             * It decodes a string into integer
             * .toString() is a method of the String Class:
             * It converts an object which was a string 
             * again into a string.
             * .chars() is a method of the String Class:
             * It returns a stream of int that represents the 
             * ASCII value of each char(~digit) composing 
             * the String version of our integer.
             * .map(c -> c-'0') method converts the ASCII value
             * of each character to its value.
             * .toArray method converts string to integer array.
             * 
             */
            
            Integer number2 = Integer.decode(bString);
            int[] bString_digits = Integer.toString(number2).chars().map(c -> c-'0').toArray();
            int end = bString_digits.length;
            Arrays.sort(bString_digits, 0, end);
            System.out.println("IX. Sorted bString: " + Arrays.toString(bString_digits));

        }     
    }
}  // StringIntegerArrays.java