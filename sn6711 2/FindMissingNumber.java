/*
* FindMissingNumber.java
*
* Version:
*     $Id$: 3.0.3
*
* Revisions:
*     $Log$: 3.0.8
*/

import java.io.*;
import java.util.*;

/**
* The FindMissingNumber program reads a text file 
* consisting of numbers and finds the missing
* number from the file.
*
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/

public class FindMissingNumber{
    
    /**
     * Read all numbers from text file stored in local directory.
     *
     * @param    null
     * @return   deciArr     Array of all the numbers in the file
     */
    
    public static int[] readfromfile() throws FileNotFoundException{
        int[] deciArr = new int[14];
        int index = 0;
        
        // Add the path name of the file which is to be read
        File test = new File("D:\\Abhinav\\Master's CS\\Sem 1\\Advanced Object Oriented Programming\\hw 3\\hw3\\FindMissingNumber\\src\\4_bits.txt");
        Scanner sc = new Scanner(test);
            try {
                while (sc.hasNextInt() == true){
                deciArr[index] = sc.nextInt();
                index++;
                }
            }
            catch ( Exception e)    {
                System.out.println("ExceptionType occurred: " + e.getMessage() );
            }
        sc.close();
        return deciArr;
    }

    /**
     * Convert all the decimal numbers to binary.
     *
     * @param    number    the decimal number to be converted to binary
     * @param    bits      number of bits
     * @return   binary    binary representation of the number 
     */
    
    public static int[] decimalToBinary(int number, int bits){
        int reversebinary[] = new int[bits];                           
        int binary[] = new int[bits];                                 
        int reverseindex = 0;
        
        // Loop to store the binary representaton in reverse order
        while( number > 0) {
            reversebinary[reverseindex++] = number % 2;
            number /= 2;
        }

        //Loop to store the binary representation in correct order
        for(int index = 0; index < reversebinary.length; index++){
            binary[index] = reversebinary[(reversebinary.length - 1) - index];
        }
    return binary;
    }


    /**
     * Convert the binary number to decimal.
     *
     * @param    binNumber    binary representation of the number
     * @return   decNumber    decimal representation of the binary number 
     */

    public static int binaryToDecimal(int[] binNumber){
        int power = 0;
        int decNumber = 0;
        
        // Converting the binary representation in decimal format 
        for(int index = binNumber.length - 1; index >= 0; index--, power++){
            decNumber += (Math.pow(2, power) * binNumber[index]);
        }
        return decNumber;
    }

    /**
    * The main program.
    *
    * @param    args    command line arguments (ignored)
    */
    
    public static void main(String[] args)throws FileNotFoundException{ 
        
        int missingValue;

        // Read all the numbers from a file and store it in an integer array
        int[] allNumbers = readfromfile();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of bits: ");
        int noOfBits = sc.nextInt();
        sc.close();
        int[] resBinary = new int[noOfBits];
        int[] decToBin = new int[noOfBits];
        int[] sumOfOnes = new int[noOfBits];

        // Initialize all the indexes of the the array sumOfOnes with 0
        for(int index = 0; index<noOfBits; index++) {
            sumOfOnes[index] = 0;
        }
        
        // Reading all the numbers one by one
        System.out.print("allNumber: ");
        for(int index = 0; index < allNumbers.length; index++){
            System.out.print(allNumbers[index] + " ");
        }
        System.out.println("");
        
        // Converting each and every Decimal number to Binary
        for(int indexAllNumber = 0; indexAllNumber < allNumbers.length; indexAllNumber++) {
            System.out.print(allNumbers[indexAllNumber] + "  "); 
            decToBin = decimalToBinary(allNumbers[indexAllNumber], noOfBits);
            System.out.print(" => Binary: ");
            
            // Loop for adding all the ones and storing it in sumOfOnes
            for (int index = 0; index < decToBin.length; index++ ) {
                sumOfOnes[index] += decToBin[index];
            }
            
            // Loop for printing binary array
            for(int index = 0; index < decToBin.length; index++){
                System.out.print(decToBin[index] + " ");
            }
            System.out.println("");
        }
        
        // Loop to print sum of ones
        System.out.print("sumOfOnes: ");
        for(int index = 0; index < sumOfOnes.length; index++){
            System.out.print(sumOfOnes[index] + " ");
        }
        System.out.println("");

        // Create Binary Number of the missing value
        for(int index = 0; index < sumOfOnes.length; index++){
            if(sumOfOnes[index] == Math.pow(2, noOfBits - 1)){     
                resBinary[index] = 0;
            }
            else if(sumOfOnes[index] == Math.pow(2, noOfBits - 1) - 1){
                resBinary[index] = 1;
            }
            else
                continue;
        }

        // Loop for printing resultant Binary representation
        System.out.print("resBinary: ");
        for(int index = 0; index < resBinary.length; index++){
            System.out.print(resBinary[index] + " ");
        }
        System.out.println("");

        // Convert Binary to decimal
        missingValue = binaryToDecimal(resBinary);

        // Printing the missing value
        System.out.println("The missing value is: " + missingValue);

    }
} // FindMissingNumber.java