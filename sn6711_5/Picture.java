/*
* Picture.java
*
* Version:
*     $Id$: 5.0.2
*
* Revisions:
*     $Log$: 5.0.1
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

/**
* The Picture class reads the pictures from a text file and
* prints the pattern.
*
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/

public class Picture {

    /**
     * Read and store an image of special characters(flash) in a vector
     *
     * @param    null
     * @return   sizeStoreVector    size of the vector
     */

    public static int readfromfile1() throws FileNotFoundException {

        File test = new File("D:\\Abhinav\\Master's CS\\Sem 1\\Advanced Object Oriented Programming\\hw 5\\hw 5.2\\Classes\\src\\flash.txt");
        Scanner sc = new Scanner(test);
        Vector<String> storeVector = new Vector<String>();
        while (sc.hasNextLine() == true){
        storeVector.add(sc.nextLine());
        }
        sc.close();
        int sizeStoreVector = storeVector.size();
        return sizeStoreVector;
    }

   /**
     * Read and store an image of special characters(Spiderman) in a vector
     *
     * @param    null
     * @return   sizeStoreVector    size of the vector
     */

    public static int readfromfile2() throws FileNotFoundException {

        File test = new File("D:\\Abhinav\\Master's CS\\Sem 1\\Advanced Object Oriented Programming\\hw 5\\hw 5.2\\Classes\\src\\Spiderman.txt");
        Scanner sc = new Scanner(test);
        Vector<String> storeVector = new Vector<String>();
        while (sc.hasNextLine() == true){
          storeVector.add(sc.nextLine());
        }
        sc.close();
        int sizeStoreVector = storeVector.size();
        return sizeStoreVector;
      }

    /**
     * A particular percentage of the image(flash) will be printed 
     *
     * @param    lines  number of lines to be printed
     * @return   void    
     */

    public static void printTheVector1(double lines) throws FileNotFoundException {

        File test = new File("D:\\Abhinav\\Master's CS\\Sem 1\\Advanced Object Oriented Programming\\hw 5\\hw 5.2\\Classes\\src\\flash.txt");
        Scanner sc = new Scanner(test);
        Vector<String> storeVector = new Vector<String>();
        while (sc.hasNextLine() == true){
        storeVector.add(sc.nextLine());
        }
        sc.close();
        for(int i = 0; i<lines; i++){
        String elements = storeVector.get(i);
        System.out.println(elements);
        }
    }

    /**
     * A particular percentage of the image(Spiderman) will be printed 
     *
     * @param    lines  number of lines to be printed
     * @return   void    
     */

    public static void printTheVector2(double lines) throws FileNotFoundException {

        File test = new File("D:\\Abhinav\\Master's CS\\Sem 1\\Advanced Object Oriented Programming\\hw 5\\hw 5.2\\Classes\\src\\Spiderman.txt");
        Scanner sc = new Scanner(test);
        Vector<String> storeVector = new Vector<String>();
        while (sc.hasNextLine() == true){
        storeVector.add(sc.nextLine());
        }
        sc.close();
        for(int i = 0; i<lines; i++){
        String elements = storeVector.get(i);
        System.out.println(elements);
        }
    }
}
