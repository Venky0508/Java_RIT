/*
* TestSortableStore.java
*
* Version:
*     $Id$: 7.2.2
*
* Revisions:
*     $Log$: 7.2.3
*/

/**
 * The TestSortableStore class contains a multi-type sortable storage with
 * abstract classes and interface.
 * 
 * @author Abhinav Ajit Menon
 * @author Srivenkatesh Shivadas Nair
 */

public class TestSortableStore {

    /**
     * Main method 
     * 
     * @param args
     */
    public static void main(String[] args) {

        // Creating an object of the concrete class

        SortableStoreString2 sortableStrings = new SortableStoreString2();
        // SortableStoreInteger2 sortableStrings = new SortableStoreInteger2();
        
        String[] strings = {"apple", "peach", "orange", "melon", "blackberry"};
        // Integer[] strings = {Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(5) };

        for (String string : strings) sortableStrings.add(string);
        // for (Integer string : strings) sortableStrings.add(string);

        System.out.printf("sortableStorage must implement toString(): %s\n", sortableStrings);
        System.out.printf("sortableStorage should be unsorted by default: isSorted()==%b\n", sortableStrings.isSorted());
        System.out.printf("sortableStorage must implement find(): find(\"apple\")==%b\n", sortableStrings.find("apple"));
        System.out.printf("sortableStorage must implement delete(): delete(\"apple\")==%b\n", sortableStrings.delete("apple"));
        System.out.printf("sortableStorage state after delete: %s\n", sortableStrings);
        System.out.printf("sortableStorage must implement sort():\n"); 
        sortableStrings.sort();
        System.out.printf("isSorted==%b\n", sortableStrings.isSorted());
        System.out.printf("sortableStorage state after sort: %s\n", sortableStrings);
        System.out.printf("sortableStorage must implement compareTo(): compareTo(strings[0],strings[1])==%d\n", sortableStrings.compareTo(strings[0],strings[1]));
    }
}
// TestSortableStore.java