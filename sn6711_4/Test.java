/*
* Test.java
*
* Version:
*     $Id$: 4.0.1
*
* Revisions:
*     $Log$: 4.0.5
*/


/**
* This program creates a storage unit where the elements are
* sorted before storing. The storage unit is a string which can
* also accept null as an element and keeps track of the number of nulls 
* added. The user can add, delete and find elements in the storage unit.
*
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/

public class Test {

	/**
     * Call the SortedStorage class and perform operations such as
	 * add, find and delete.
     *
     * @param    aSortedStorage  object of SortedStorage class
     * @return   void
     */

	public static void testIt(SortedStorage aSortedStorage)	{

		// Values to be inserted, found and deleted.
		String toInsert[] = { "1", null, "1"};
		String toDelete[] = { "1", null, "1"};
		String toFind[]   = { "1", null, "1"};

		// Insert all the elements in th storage unit one by one.
		for (int index = 0; index < toInsert.length; index ++ )	{
			System.out.println("- add(" + toInsert[index] + "): "  + aSortedStorage.add(toInsert[index]));
		}

		// Check if the storage unit contains any null
		System.out.println("- includesNull: "  + aSortedStorage.includesNull());

		// Find all the elements one by one
		for (int index = 0; index < toFind.length; index ++ )	{
			System.out.println("- find(" + toFind[index] + "): "  + aSortedStorage.toFind(toFind[index]));
		}

		// Delete the elements one by one
		for (int index = 0; index < toDelete.length; index ++ )	{
			System.out.println("- delete(" + toDelete[index] + "): "  + aSortedStorage.delete(toDelete[index]));
		}
	}

	/**
    * The main program.
    *
    * @param    args    command line arguments (ignored)
    */
	public static void main(String[] args )	{
		
		// Create an object of the class SortedStorage
		SortedStorage aSortedStorage = new SortedStorage();

		// Pass the object to the testIt function
		testIt(aSortedStorage);
	}
}