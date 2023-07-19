/*
 * NumberEqualCube.java
 *
 * Version:
 *     $Id$: 1.0.1
 *
 * Revisions:
 *     $Log$: 1.0.8
 */

/**
 * The NumberEqualCube program calculates and prints all the 
 * numbers between 1 and 100000 whose sum of digits raised 
 * to the power of its length is equal to the number itself.
 *
 * @author      Abhinav Ajit Menon
 * @author      Srivenkatesh Shivadas Nair
 */

public class NumberEqualCube {

    /**
     * Calculate the power of a given number
     *
     * @param    baseNumber     base number
     * @param    power          power
     * @return   answer         result of the power
     */

    public static int power(int baseNumber, int power) {  
        int answer = 1;  
        for (int index3 = 1; index3 <= power; index3++)   
        answer = answer * baseNumber;   
        return answer;  
    }  


  /**
   * The main program.
   *
   * @param    args    command line arguments (ignored)
   */
    public static void main(String args[]) {
        int tempNumber, remainder, result = 0, index = 0;

       /* Check if the NumberEqualCube condition is satisfied for numbers
          between 1 and 100000 */

        for (int index2 = 1; index2 <= 100000; index2++){
            tempNumber = index2;     
            result=0;

            // Calculate length of the number
            for (index = 0; tempNumber != 0; index++) {
                tempNumber = tempNumber/10;
            }      
            
            /* Calculate the sum of the digits rasied to the power of
            its length  and initialize tempNumber again as the value was 
            changed previously. */

            for ( tempNumber = index2; tempNumber != 0; tempNumber = tempNumber / 10)
            {
                remainder = tempNumber % 10;
                result = result + power(remainder, index);
            }

            //Check if the sum is equal to the original number

            if(result == index2)
                System.out.println(index2); 
        }      

    }

}  //NumberEqualCube   

