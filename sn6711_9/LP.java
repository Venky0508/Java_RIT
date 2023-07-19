/*
* LP.java
*
* Version:
*     $Id$: 9.0.1
*
* Revisions:
*     $Log$: 9.0.5
*/

/**
 * The LP class contains a cunstructor for initializing the values and overrides
 * the compareTo and toString functions
 * 
 * @author Abhinav Ajit Menon
 * @author Srivenkatesh Shivadas Nair
 */

public class LP implements Comparable<LP>{

    // Declaring instance variables
    int year;
    String title;
    String artist;
    float length;
    int tracks;

    // Constructor
    public LP(int year, String title, String artist, float length, int tracks){
        this.year = year;
        this.title = title;
        this.artist = artist;
        this.length = length;
        this.tracks = tracks;
    }

    /**
     * ompareTo Method: to compare the hashcodes of 2 elements
     *
     * @param y An element of type LP
     * @return 1, -1, 0
     */

    @Override
    public int compareTo(LP y) {
        if(this.hashCode() > y.hashCode()) {
            return 1;
        }
        else if (this.hashCode() == y.hashCode()) {
            return 0;
        }
        else {
            return -1;
        }
    }

    /**
     * ToString Method: Returns the string representation of all objects
     *
     * @return String String of all the elements in the ArrayList
     */
    public String toString(){
        return "" + this.year + " " + this.title + " " + this.artist + " " + this.length + " " + this.tracks;
    }
} // LP.java