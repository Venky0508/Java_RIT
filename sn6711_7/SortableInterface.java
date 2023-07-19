/*
* SortableInterface.java
*
* Version:
*     $Id$: 7.2.2
*
* Revisions:
*     $Log$: 7.2.3
*/

/**
 * The SortableInterface is an interface that enforces 3 mthods - 
 * 1. sort()
 * 2. isSorted()
 * 3. compareTo(Object x, Object y)
 * 
 * @author Abhinav Ajit Menon
 * @author Srivenkatesh Shivadas Nair
 */

public interface SortableInterface { 
    
    public abstract void sort();
    public abstract boolean isSorted();
    public abstract int compareTo(Object x, Object y);
}
// SortableInterface.java