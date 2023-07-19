/*
* StoreEverythingI.java
*
* Version:
*     $Id$: 8.0.3
*
* Revisions:
*     $Log$: 8.0.2
*/

/**
* This Sorted Storage Interface contains all the method declarations for add,
* delete and find and stores the elements of generic type "T".
* 
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/

// Declaring an interface of generic type "T"
public interface StoreEverythingI<T> {
	//Abstract method declarations with signatures of type "T"
	public boolean delete(T element);
	public boolean find(T element);
	public boolean add(T element);
	//Overiding the built-in toString method
	public String toString();
}