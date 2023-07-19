/*
* StorageInterface.java
*
* Version:
*     $Id$: 9.0.1
*
* Revisions:
*     $Log$: 9.0.5
*/

/**
 * The Storage Interface is an Interface that declares the following methods:
 * 1. add
 * 2. find
 * 3. includesNull
 * 4. delete
 * 
 * @author Abhinav Ajit Menon
 * @author Srivenkatesh Shivadas Nair
 */

public interface StorageInterface<E extends Comparable<E>> {
    boolean add(E x);
    boolean find(E x);
    boolean includesNull();
    boolean delete(E x);
 } // StorageInterface.java