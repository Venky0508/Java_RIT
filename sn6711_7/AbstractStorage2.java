/*
* AbstractStorage2.java
*
* Version:
*     $Id$: 7.2.2
*
* Revisions:
*     $Log$: 7.2.3
*/

/**
 * The AbstractStorage2 class enforces 6 mthods - 
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


public abstract class AbstractStorage2 {

    // Declaring the variables to be used in the concrete class.
    static int nullCounter = 0;
    int index = 0;
    boolean flag = true;
    Integer intArr[] = new Integer[10];
    String strArr[] = new String[10];
    Object objArr[] = new Object[10];
    char charArr1[] = new char[10];
    char charArr2[] = new char[10];
    char isSortArr1[] = new char[10];
    char isSortArr2[] = new char[10];
    public boolean sortedState = isSorted();
    String res = "";
    
    // Enforcing the abstract methods
    public abstract boolean add(Object x);
    public abstract boolean find(Object x);
    public abstract boolean delete(Object x);
    public abstract int howManyNulls();
    public abstract boolean isSorted();
    public abstract String toString();

}
// AbstractStorage2.java
