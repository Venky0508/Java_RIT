/*
 * Coins.java
 *
 * Version:
 *     $Id$: 1.0.1
 *
 * Revisions:
 *     $Log$: 1.0.9
 */

/**
 * The Coins program determines the longest sequence of coins 
 * that exist adding up to a given value
 *
 * @author      Abhinav Ajit Menon
 * @author      Srivenkatesh Shivadas Nair
 */


public class Coins {

	/**
     * The main program.
     *
     * @param    args    command line arguments (ignored)
     */

	public static void main(String[] args) {
		int[] mycoin = {1,4,4,5,8};
		int[] topay = {9,6,4,7,8};
		int[] result = new int[mycoin.length];
		
		for(int outerindex=0;outerindex<topay.length;outerindex++) {
			int payamount = topay[outerindex];
			result = compute(mycoin,payamount);
			System.out.print(payamount+" cents: ");
			for(int index=0;index<mycoin.length;index++) {
				
				if(result[index]!=0) {
					System.out.print(result[index] + " cents   ");
				}
				
			}
			System.out.println("");
		}
		
		
	}
	
	/**
	 * Find the longest sequence of coins
	 *
	 * @param    mycoin    All the available coins
	 * @param    topay     target amount
	 * @return   coinarray  coins used to make the target sum
	 */
	
	public static int[] compute(int[] mycoin,int topay) {
		
		// value after taking the difference of target and coin

		int intermediatevalue;
		
		// Target amount
		
		int initialvalue;

		// All the coins that can be used to add up to the target amount

		int[] coinarray=new int[5];

		// Initial value to be subtracted from the amount to be paid

		for(int outerindex=0;outerindex<mycoin.length;outerindex++) {
			
			coinarray= new int[5];
			initialvalue = topay;
			int coinindex=0;
			
			// Traverses all the given coins

			for(int innerindex=outerindex;innerindex<mycoin.length;innerindex++) {
				intermediatevalue = initialvalue - mycoin[innerindex];

                // condition for continuing the iteration

				if(intermediatevalue >= mycoin[innerindex]) {
					coinarray[coinindex] = mycoin[innerindex];
					initialvalue = intermediatevalue;					
					coinindex++;
				}

				else if(intermediatevalue<0) {
					break;
				}

                // returns the result

				else if(intermediatevalue==0) {
					coinarray[coinindex] = initialvalue;
					return coinarray;
				}			
			}
		}
		return coinarray;
	}
}
