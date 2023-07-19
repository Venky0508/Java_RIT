/*
* NumberEqualCube.java
*
* Version:
*     $Id$: 11.0.1
*
* Revisions:
*     $Log$: 11.0.5
*/

/**
 * The NumberEqualCube program calculates and prints all the 
 * numbers between 1 and 100000 whose sum of digits raised 
 * to the power of its length is equal to the number itself.
 *
 * @author      Abhinav Ajit Menon
 * @author      Srivenkatesh Shivadas Nair
 */

// Creating a subclass of Thread class
public class NumberEqualCube extends Thread{
     
    int info;
    static int total;

    public NumberEqualCube(int info, int total){
        this.info = info;
        NumberEqualCube.total= total;
    }

    /**
     * Calculate the power of a given number
     *
     * @param    baseNumber     base number
     * @param    power          power
     * @return   answer         result of the power
     */

    public static int power(int baseNumber, int power) {  
        int answer = 1;  
        for (int index = 1; index <= power; index++)   
        answer = answer * baseNumber;   
        return answer;  
    }

    /**
     * Compute the numbers equal to the cube of their individual digits
     *
     * @param    index1     Beginning index for a single thread
     * @param    index2     Ending index for a single thread
     * @return   void
     */
    public void compute(int index1,int index2) {
        int tempNumber, tempPrint, remainder, plusCounter, result = 0, index = 0, printIndex;

       /* Check if the NumberEqualCube condition is satisfied for numbers
          between 1 and 10000000 */
        for (int index4 = index1; index4 <= index2; index4++){
            tempNumber = index4;     
            result=0;

            // Calculate length of the number
            for (index = 0; tempNumber != 0; index++) {
                tempNumber = tempNumber/10;
            }
            
            /* Calculate the sum of the digits rasied to the power of
            its length  and initialize tempNumber again as the value was 
            changed previously. */
            for ( tempNumber = index4; tempNumber != 0; tempNumber = tempNumber / 10)
            {
                remainder = tempNumber % 10;
                result = result + power(remainder, index);
            }

            //Check if the sum is equal to the original number
            plusCounter = 0;
            if(index4 == 0){
                index =1;
            }

            int[] intArr = new int[index];
            tempPrint = index4;

            // Store the individual digits into an integer array
            for(int arrIndex = 0; arrIndex < index; arrIndex++){
                intArr[arrIndex] = tempPrint % 10;
                tempPrint /=10;
            }

            // Print the required numbers
            if(result == index4){
                System.out.print(index4 + " = ");
                for(printIndex = index; printIndex > 0; printIndex--){
                    System.out.print(intArr[printIndex - 1] + "^" + index);
                    plusCounter++;
                    if (plusCounter != index){
                        System.out.print(" + ");
                    }
                }
            System.out.println();
            } 
        }      
    }

    // The run method
    public void run(){
            //Total number i.e. 10000000 divided by the total number of threads so that all the threads process equal number of numbers
            int multiplier = Math.floorDiv(10000000, total);
            // Condition for the first thread of execution
            if (info == 1){
                int upper = info * multiplier;
                compute(0, upper);
                try { sleep(1000); } catch (  InterruptedException e ) { }
            }
            // Condition for all the other threads of execution
            else{
                int lower = (info-1)*multiplier;
                int upper = info * multiplier;
                compute(lower, upper);
                try { sleep(1000); } catch (  InterruptedException e ) { }
            }
    }


  /**
   * The main program.
   *
   * @param    args    command line arguments (ignored)
   */
    public static void main(String args[]) throws InterruptedException {
         
        if (args.length == 1){
            int limit = Integer.parseInt(args[0]);
            for (int index = 1; index <= limit; index++){
                NumberEqualCube thread = new NumberEqualCube(index,limit);
                thread.start();
                thread.join();
            }
        }
        else{
            System.out.println("No command line arguement entered.");
            System.exit(0);
        }
    }
}  //NumberEqualCube   
