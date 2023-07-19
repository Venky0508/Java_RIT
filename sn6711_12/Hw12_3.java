/*
 * Hw12_3.java
 *
 * Version:
 *     $Id$: 12.0.1
 *
 * Revisions:
 *     $Log$: 12.0.5
 */

/**
 * We have to write a sumilation hwo roofers get shingles on a roof.
 * The work involves n roofers and k shingles to cover the whole roof.
 * The objective is to work with synchronized threads.
 * You can not use synchronized data structures from the Java environment.
 *
 * @author      Abhinav Ajit Menon
 * @author      Srivenkatesh Shivadas Nair
 */

// Creating a subclass of Thread class
public class Hw12_3 extends Thread    {
    private int id;
    static Object[]  roofersArr;
    static int     counter = 1;
    static int shingles = 0;

    boolean flag = false;
    Object first;
    Object second;

    //Parameterized Constructor of the class
    public Hw12_3(int id, Object first, Object second) {
        this.id         = id;
        this.first      = first;
        this.second     = second;
    }

    /**
     * Compute and populate the roofers array with objects.
     *
     * @param    MAX     number of threads
     * @return   None
     */
    public static void init(int MAX)    {
        roofersArr = new Object[MAX + 1];
        for ( int index = 0; index < MAX + 1; index ++ )
            roofersArr[index] = new Object();
    }

    // Run Method
    public void run() {
        //Number of shingles is the no. of times the simulation would repeat
        for ( int index = 1; index <= shingles; index ++ ) {
            //Every thread has its first and second but all of them refer to the same static roofers array.
            synchronized ( first ) {
                synchronized ( second ) {
                    //To notify the first object in wait once the last thread enters the sync. block and the procesing continues
                    second.notify();
                    //Print Statement for the first thread
                    if (id == 1) {
                        System.out.println("Helper pick up next shingle (so many shingles = "+ index + ") is handed to roofer "+id);
                    }
                    //Print Statement for all the other threads
                    else{
                        System.out.println("shingle number "+index+" is handed to next roofer ("+id+")");
                    }
                    //Print Statement after the last shingle is passed on to the last roofer
                    if (first == roofersArr[roofersArr.length - 2]){
                        System.out.print("and the next shingle is put on the roof\n");
                    }

                    try {
                        //If the id is less than the max. no. of threads
                        if ( id < roofersArr.length - 1 )    {
                            if ( ! flag )    {
                                //Condition for the creation of the last thread
                                if ( counter == roofersArr.length - 2 )
                                    ( new Hw12_3(counter+1, roofersArr[roofersArr.length - 2], roofersArr[0]) ).start();
                                    //All other threads are created here
                                else
                                    ( new Hw12_3(counter+1, roofersArr[counter], roofersArr[counter+1] ) ).start();
                                flag = true;
                            }
                        }
                        counter ++;
                    }
                    catch ( Exception e ) { }
                }
                try {
                    //for the last iteration we dont put any thread in wait inorder to terminate the program
                    if (index == shingles){}
                    //otherwise
                    else{
                        first.wait();
                    }
                }
                catch ( Exception e ) { }
            }
        }
    }
    public static void main (String args []) {

        if (args.length == 2){

            int roofers = Integer.parseInt(args[0]);
            //This method populates the roofers array.
            init(roofers);
            shingles = Integer.parseInt(args[1]);
            //First thread is created here and start method is called.
            new Hw12_3(1, roofersArr[0], roofersArr[1]).start();
        }
        else{
            System.out.println("No Command line arguement entered.");
            System.exit(0);
        }
    }
}