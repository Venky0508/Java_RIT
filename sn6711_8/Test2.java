/*
* Test 2.java
*
* Version:
*     $Id$: 8.0.1
*
* Revisions:
*     $Log$: 8.0.5
*/

/**
* The Test2 class creates objects and class the methods in the StorEverything class
* 
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/

public class Test2 {

	/**
     * test Method: Create the test() method with type <T> to add, find and delete the elements
     *
     * @param    what     			The string to be printed
	 * @param    aStoreEverything   The storage unit
	 * @param    theObjects     	The elements to be added
     * @return   void
     */

	public static<T> void test(String what, StoreEverything<T> aStoreEverything, T[] theObjects)	{

		System.out.println(what + ":  ");
		for (int index = 0; index < theObjects.length; index ++ )	{
			System.out.println("	add(" + theObjects[index] + "): "  + aStoreEverything.add(theObjects[index]));
		}
		for (int index = 0; index < theObjects.length; index ++ )	{
			System.out.println("	find(" + theObjects[index] + "): "  + aStoreEverything.find(theObjects[index]));
		}
		System.out.println("---------------------------------------");
		System.out.println("	" +  aStoreEverything);
		System.out.println("---------------------------------------");

		for (int index = 0; index < theObjects.length; index ++ )	{
			System.out.println("delete(" + theObjects[index] + "): "  + aStoreEverything.delete(theObjects[index]));
		}

		System.out.println(	"All should be deleted");
		System.out.println("	" +  aStoreEverything);
	}

	/**
     * testSelf Method: Create the testSelf() to create an Object of StoreEverything which stores itself
     *
     * @param    what     			The string to be printed
     * @return   void
     */ 
	public static<T> void testSelf(String what)	{
		System.out.println(what + ":  ");
		// Create an object of type<StoreEverything<?>> which can store a type 'StoreEverything' containing any type '?'
		StoreEverything<StoreEverything<?>> aStoreEverything = new StoreEverything<StoreEverything<?>>() ;
		aStoreEverything.add(aStoreEverything);
		System.out.println("	" +  aStoreEverything);
	}

	/**
     * testAll1 Method: Create the testAll1() method with type <T> to store an array of StoreEverything objects to itself
     *
     * @param    void
     * @return   void
     */
	public static<T> void testAll1() {
		StoreEverything<?> theStoreEverything[] = { new StoreEverything<StoreEverything<?>>(), new StoreEverything<StoreEverything<?>>(), new StoreEverything<StoreEverything<?>>() };
		StoreEverything<StoreEverything<?>> aStoreEverythings = new StoreEverything<StoreEverything<?>>();
		test("StoreEverything: Objects", aStoreEverythings, theStoreEverything);
	}

	/**
     * testAll2 Method: Create the testAll2() method with type <T> to create objects of String class, Integer class and Object class
     *
     * @param    void
     * @return   void
     */
	public static<T> void testAll2() {
		String theStrings[] = { "3", "3", "2", "4" };
		// Create an object of type <String>
		StoreEverything<String> aStoreEverythings1 = new StoreEverything<>();
		test("StoreEverything: String", aStoreEverythings1, theStrings);

		Integer theIntegers[] = { Integer.valueOf(3), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(4) };
		// Create an object of type <Integer>
		StoreEverything<Integer> aStoreEverythings2 = new StoreEverything<Integer>();
		test("StoreEverything: Integer", aStoreEverythings2, theIntegers);

		Object theObjects[] = { new Object(), new Object(), new Object(), new Object() };
		// Create an object of type <Object>
		StoreEverything<Object> aStoreEverythings3 = new StoreEverything<Object>();
		test("StoreEverything: Objects", aStoreEverythings3, theObjects);

	}

	/**
     * main Method: Create the main() method to call the functions testAll1(), testAll2() and testSelf()
     *
     * @param    args[]		argument list
     * @return   void
     */
	public static void main(String args[] )	{
		testAll1();
		testAll2();
		testSelf("StoreEverything stores itself");
	}
}
// Test2.java