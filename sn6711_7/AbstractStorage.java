/*
* AbstractStorage.java
*
* Version:
*     $Id$: 7.1.2
*
* Revisions:
*     $Log$: 7.1.3
*/

/**
 * The AbstractStorage class enforces 6 mthods - 
 * 1. add()
 * 2. find()
 * 3. delete()
 * 4. howManyNulls()
 * 5. isSorted()
 * 6. toString()
 * 
 * @author Abhinav Ajit Menon
 * @author Srivenkatesh Shivadas Nair
 */

public abstract class AbstractStorage {

    // Declaring the variables to be used in the concrete class.
    static int nullCounter = 0;
    int index = 0;
    boolean flag = true;
    Integer intArr[] = new Integer[10];
    String strArr[] = new String[10];
    Object objArr[] = new Object[10];
    String res = "";
    public boolean sortedState = isSorted();
    
    // Enforcing the abstract methods
    public abstract boolean add(Object x);
    public abstract boolean find(Object x);
    public abstract boolean delete(Object x);
    public abstract int howManyNulls();
    public abstract boolean isSorted();
    public abstract String toString();

}
// AbstractStorage.java
