/*
* SortedUnsortedStorage.java
*
* Version:
*     $Id$: 7.1.1
*
* Revisions:
*     $Log$: 7.1.2
*/

/**
 * The TestSortableStore class contains a multi-type sortable storage with
 * abstract classes.
 * 
 * @author Abhinav Ajit Menon
 * @author Srivenkatesh Shivadas Nair
 */

class SortedUnsortedStorage{
    
    /**
     * Main method 
     * 
     * @param args
     */
    public static void main(String[] args) {

        // STORE INTEGERS

        System.out.println();
        System.out.println("Store Integers in SortableStoreInteger: ");
        Integer theIntegers[] = {2,3,4,null};
        // Creating an object of the concrete class
        SortableStoreInteger SSI = new SortableStoreInteger();
        
        // Call the add() method
        for (int index = 0; index < theIntegers.length; index ++ )	{
			System.out.println("	add(" + theIntegers[index] + "): "  + SSI.add(theIntegers[index]));
        }

        // Call the find() method
        for (int index = 0; index < theIntegers.length; index ++ )	{
			System.out.println("	find(" + theIntegers[index] + "): "  + SSI.find(theIntegers[index]));
        }

        // Call the howManyNulls() method
        System.out.println("	howManyNulls:  " +  SSI.howManyNulls());
        
        //  // Call the isSorted() method
        System.out.println("	isSorted:  " +  SSI.isSorted());

        System.out.println("---------------------------------------");
		System.out.println("	" +  SSI);
		System.out.println("---------------------------------------");

        // Call the delete() method
        for (int index = 0; index < theIntegers.length; index ++ )	{
			System.out.println("	delete(" + theIntegers[index] + "): "  + SSI.delete(theIntegers[index]));
        }

        System.out.println("---------------------------------------");
		System.out.println("	" +  SSI);
		System.out.println("---------------------------------------");


        // STORE STRINGS

        System.out.println();
        System.out.println("Store Strings in SortableStoreString: ");
        String theStrings[] = {"3", "3", "2", "4"};
        // Creating an object of the concrete class
        SortableStoreString SSS = new SortableStoreString();
        
        // Call the add() method
        for (int index = 0; index < theStrings.length; index ++ )	{
			System.out.println("	add(" + theStrings[index] + "): "  + SSS.add(theStrings[index]));
        }

        // Call the find() method
        for (int index = 0; index < theStrings.length; index ++ )	{
			System.out.println("	find(" + theStrings[index] + "): "  + SSS.find(theStrings[index]));
        }

        // Call the howManyNulls() method
        System.out.println("	howManyNulls:  " +  SSS.howManyNulls());
        
        // Call the isSorted() method
        System.out.println("	isSorted:  " +  SSS.isSorted());

        System.out.println("---------------------------------------");
		System.out.println("	" +  SSS);
		System.out.println("---------------------------------------");

        // Call the delete() method
        for (int index = 0; index < theStrings.length; index ++ )	{
			System.out.println("	delete(" + theStrings[index] + "): "  + SSS.delete(theStrings[index]));
        }

        System.out.println("---------------------------------------");
		System.out.println("	" +  SSS);
		System.out.println("---------------------------------------");

        // STORE ITSELF

        System.out.println();
        System.out.println("SortableStoreStore stores itself: ");
        // Creating an object of the concrete class
        SortableStoreStore SSStore = new SortableStoreStore();

        // Call the add() method
        System.out.println("	add(SSStore): "  + SSStore.add(SSStore));
        
        // Call the find() method
        System.out.println("	find(SSStore): "  + SSStore.find(SSStore));

        // Call the howManyNulls() method
        System.out.println("	howManyNulls:  " +  SSStore.howManyNulls());
        
        // Call the isSorted() method
        System.out.println("	isSorted:  " +  SSStore.isSorted());

        System.out.println("---------------------------------------");
        System.out.println("	" +  SSStore);
        System.out.println("---------------------------------------");

        // Call the delete() method
        System.out.println("	delete(SSStore): "  + SSStore.delete(SSStore));

        System.out.println("---------------------------------------");
        System.out.println("	" +  SSStore);
        System.out.println("---------------------------------------");
    
    }
}
// SortedUnsortedStorage.java