/*
* Picture.java
*
* Version:
*     $Id$: 3.0.2
*
* Revisions:
*     $Log$: 3.0.5
*/

package Picture;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

/**
* The Picture program reads three text files and creates a 
* 2 player game wherein the first player to guess the correct 
* word win. For evey correct guess, the user gets to see a 
* specific percentage of an image.
*
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/

public class Picture{

  static final Scanner readGuess = new Scanner(System.in);
  
  /**
     * Read and store an image of special characters(flash) in a vector
     *
     * @param    null
     * @return   sizeStoreVector    size of the vector
     */

  public static int readfromfile1() throws FileNotFoundException {

    File test = new File("D:\\Abhinav\\Master's CS\\Sem 1\\Advanced Object Oriented Programming\\hw 3\\hw 3.2\\Picture\\src\\Picture\\flash.txt");
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

    File test = new File("D:\\Abhinav\\Master's CS\\Sem 1\\Advanced Object Oriented Programming\\hw 3\\hw 3.2\\Picture\\src\\Picture\\Spiderman.txt");
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
     * Read words from a text file
     *
     * @param    counter    keeps track of the player number
     * @return   ch1        first word in the file
     * @return   ch2        second word in the file
     * @return   invalid    invalid read
     */

  public static char [] readfromfile(int counter) throws FileNotFoundException
 {
   File test = new File("D:\\Abhinav\\Master's CS\\Sem 1\\Advanced Object Oriented Programming\\hw 3\\hw 3.2\\Picture\\src\\Picture\\words.txt");
   Scanner sc = new Scanner(test);
  
   char[] ch1 = new char[2];
   char[] ch2 = new char[2];
   char [] invalid = {'o'};
       while (sc.hasNextLine() == true)
       {   
           // Return word for player 1
           if(counter == 1)
           {
               String line1 = sc.nextLine();
               ch1 = line1.toCharArray();
               return ch1;
           }
           
           // Return word for player 2
           else if(counter == 2)
           {
               String line2 = sc.nextLine();
               String line3 = sc.nextLine();
 
               ch2 = line3.toCharArray();
               return ch2;
           }
           sc.close();
       }
       return invalid;
   }

  /**
     * A particular percentage of the image(flash) will be printed 
     *
     * @param    lines  number of lines to be printed
     * @return   void    
     */

  public static void printTheVector1(double lines) throws FileNotFoundException {

    File test = new File("D:\\Abhinav\\Master's CS\\Sem 1\\Advanced Object Oriented Programming\\hw 3\\hw 3.2\\Picture\\src\\Picture\\flash.txt");
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

    File test = new File("D:\\Abhinav\\Master's CS\\Sem 1\\Advanced Object Oriented Programming\\hw 3\\hw 3.2\\Picture\\src\\Picture\\Spiderman.txt");
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
     * Read the user's guess 
     *
     * @param    void
     * @return   guess   user entered character    
     */

  public static char readUserInput() {
    Scanner sc = new Scanner(System.in);   
    char guess = sc.next().charAt(0);
    return guess;
  }

  /**
    * The main program.
    *
    * @param    args    command line arguments (ignored)
    */ 
    
    public static void main (String [] args) throws FileNotFoundException {
    
    // Reading the words from the file
    int counter = 1;
    char arr1[] =  readfromfile(counter);
    String player1Word = String.valueOf(arr1);
    counter++;
    char arr2[] = readfromfile(counter);
    String player2Word = String.valueOf(arr2);
    
    // Declaring variables for player 1
    int counter1 = 0;
    int percentage1;
    float noOfLines1;
    double floorNoOfLines1;
    int flagCounter1 = 0;
    
    // Declaring variables for player 2
    int counter2 = 0;
    int percentage2;
    float noOfLines2;
    double floorNoOfLines2;
    int flagCounter2 = 0;
    
    // Reading both the images and storing it in vectors
    int vectorSize1 = readfromfile1();
    int vectorSize2 = readfromfile2();
    char[] player1Array = new char[player1Word.length()];
    char[] player2Array = new char[player2Word.length()];
    char[] player1result = new char[player1Word.length()];
    char[] player2result = new char[player2Word.length()];
    int playercounter = 1;
    boolean playerflag = true;

    // Initialize the player1result array with '.'
    for (int index = 0; index < player1Word.length(); index++){
      player1result[index] = '.';
    } 

    // Initialize the player2result array with '.'
    for (int index = 0; index < player2Word.length(); index++){
      player2result[index] = '.';
    } 
    
    // Loop for alternating between player 1 and player 2
    while (playerflag == true) {

      // PLAYER 1
      if (playercounter == 1) {
        System.out.print("Player 1:  ");
        
        // Initializing the Player 1 Array
        for (int index = 0; index < player1Word.length(); index++) {
          player1Array[index] = player1Word.charAt(index);
        }
        
        // Printing the Player 1 Array
        for (int index = 0; index < player1Word.length(); index++) {
          System.out.print(player1Array[index]);
        }
        System.out.println("");

        // Print the previous guesses of player 1
        System.out.print("Previous Guesses: ");
        for (int index = 0; index < player1Word.length(); index++) {
          System.out.print(player1result[index]);
        }
        System.out.println("");

        // Read player 1 input
        System.out.println("Enter your guess: ");
        char player1Guess = readUserInput();
        
        // Initialize the Player 1 Result array with the correct characters
        for (int index = 0; index < player1Word.length(); index++){
          if(player1Guess == player1Array[index]){
            player1result[index] = player1Guess;
            counter1++;
            break;
          }     
        }

        // Print the player's progress
        System.out.print("Your Guess: ");
        for (int index = 0; index < player1Word.length(); index++) {
          System.out.print(player1result[index]);
        }
        System.out.println("");

        percentage1 = (counter1 * 100) / player1Word.length();
        noOfLines1 = (vectorSize1 * percentage1) / 100;
        floorNoOfLines1 = Math.floor(noOfLines1);

        // Display certain percentage of the image
        printTheVector1(floorNoOfLines1);
        flagCounter1 = 0;
        for (int index = 0; index < player1Word.length(); index++){
          if(player1result[index] != '.') {
            flagCounter1++;
          }
        }

        // Check if player 1 has guessed all the characters correctly
        if (flagCounter1 == player1Word.length()) {
          System.out.println("Player 1 is the winner!!!");
          playerflag = false;
          break;
        }
      }
      playercounter++;

      // PLAYER 2
      if (playercounter == 2) {
        System.out.print("Player 2:  ");
        
        // Initializing the Player 2 Array
        for (int index = 0; index < player2Word.length(); index++) {
          player2Array[index] = player2Word.charAt(index);
        }
        
        // Printing the Player 2 Array
        for (int index = 0; index < player2Word.length(); index++) {
          System.out.print(player2Array[index]);
        }
        System.out.println("");

        // Print the previous guesses of player 2
        System.out.print("Previous Guess: ");
        for (int index = 0; index < player2Word.length(); index++) {
          System.out.print(player2result[index]);
        }
        System.out.println("");

        // Read player 2 input
        System.out.println("Enter your guess: ");
        char player2Guess = readUserInput();

        // Initialize the Player 2 Result array with the correct characters
        for (int index = 0; index < player2Word.length(); index++){
          if(player2Guess == player2Array[index]){
            player2result[index] = player2Guess;
            counter2++;
            break;
          }
        }

        // Print the player's progress
        System.out.print("Your Guess: ");
        for (int index = 0; index < player2Word.length(); index++) {
          System.out.print(player2result[index]);
        }
        System.out.println("");

        percentage2 = (counter2 * 100) / player2Word.length();
        noOfLines2 = (vectorSize2 * percentage2) / 100;
        floorNoOfLines2 = Math.floor(noOfLines2);

        // Display certain percentage of the image
        printTheVector2(floorNoOfLines2);
        flagCounter2 = 0;
        for (int index = 0; index < player2Word.length(); index++){
          if(player2result[index] != '.') {
            flagCounter2++;
          }
        }

        // Check if player 2 has guessed all the characters correctly
        if (flagCounter2 == player2Word.length()) {
          System.out.println("Player 2 is the winner!!!");
          playerflag = false;
          break;
        }
      }

      playercounter--;

      // If any one player guesses the word correctly, break the loop
      if(flagCounter1 == player1Word.length() || flagCounter2 == player2Word.length()){
        playerflag = false;
      }
    }
  }
} // Picture.java
