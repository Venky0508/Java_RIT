/*
 * LongestCommonDNAsegment.java
 *
 * Version:
 *     $Id$: 1.0.1
 *
 * Revisions:
 *     $Log$: 1.0.8
 */

/**
 * The LongestCommonDNAsegment program calculates and prints the length
 * of the largest common substring in two given strings.
 *
 * @author      Abhinav Ajit Menon
 * @author      Srivenkatesh Shivadas Nair
 */

public class LongestCommonDNAsegment {

    /**
     * Print the output
     *
     * @param    label      labels
     * @param    theDNA     string characters
     */

    public static  void printTheDNA(String label, char[] theDNA) {
        System.out.print(label);

        // Print each character of the array

        for ( int index = 0; index < theDNA.length; index ++)
            System.out.print( theDNA[index]);
        System.out.println();
        }
    
    /**
     * Calculate the maximum length of the common substring
     *
     * @param    arr    common substring
     * @return   max    maximum length
     */

    static int maxsegment ( int [] arr){
      int max = 0;

      // Initialize max variable with the first value in the array

      max = arr[0];

      // Calculate the maximum number from the array and store it in max

      for (int index = 1; index < arr.length; index++){
        if(max < arr[index]) {
            max = arr[index];
        }
      }
      return max;
    } 

    /**
     * Find the common substrings from the two given strings
     *
     * @param    firstDNA    first string
     * @param    secondDNA   second string
     * @return   counterArr  Array storing all the counters
     */

    public static int[] findLongestCommonDNAsegment(char[] firstDNA, char[] secondDNA)   {
        int temp1, temp2, counter = 0;

        // Create an array to store all the counters 

        int counterArr[] = new int[50];

        // Traverse the first DNA string

        for (int index1 = 0, index2 = 0; index1 < firstDNA.length; index1++, index2++) {
            counter = 0;

                // Traverse the second DNA string

                for (int index3 = 0; index3 < secondDNA.length; index3++) {

                    // Check if the first characters of both the strings match

                    if (firstDNA [index1] == secondDNA [index3]) {
                        temp1 = index1;
                        temp2 = index3;

                        // Check if all the consecutive characters match

                        while (temp1 < firstDNA.length && temp2 < secondDNA.length && firstDNA [temp1] == secondDNA [temp2]) {
                            temp1++;
                            temp2++;
                            counter++;
                            }

                        // Store all the counters in the array

                        counterArr[index2] = counter;
                    }
                            
                }
        }
    return counterArr;
    }
    
    /**
     * The main program.
     *
     * @param    args    command line arguments (ignored)
     */
    public static void main(String[] args) {
    char[] dnaOne = {'t', 'a', 'c', 'g', 'g'};
    char[] dnaTwo = {'a', 'c', 'g', 't'};
    int lcds [] = new int[50];
    printTheDNA("first DNA:         ", dnaOne);
    printTheDNA("second DNA:        ", dnaTwo);
    System.out.print("Longest in common:    ");
    lcds = findLongestCommonDNAsegment(dnaOne, dnaTwo);
    System.out.println(maxsegment(lcds));
    }
}  //LongestCommonDNAsegment
