/*
* PercentCalculation.java
*
* Version:
*     $Id$: 5.0.2
*
* Revisions:
*     $Log$: 5.0.1
*/

/**
* The PercentCalculation class calculates the percentage of pattern
* to be printed based on the player inputs.
*
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/

public class PercentCalculation {
    
    // Declaring class variables
    static int percentage;
    static float noOfLines;
    static double floorNoOfLines;
   
    /**
     * Calculate the number of lines.
     *
     * @param    counter            knumber of matched characters
     * @param    len                length of the word
     * @param    vectSize           size of the vector
     * @return   floorNoOfLines     number of lines to be printed
     */

    public static double percentCalc(int counter, int len, int vectSize) {
        percentage = (counter * 100) / len;
        noOfLines = (vectSize * percentage) / 100;
        floorNoOfLines = Math.floor(noOfLines);
        return floorNoOfLines;
    }
}