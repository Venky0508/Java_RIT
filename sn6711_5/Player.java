/*
* Player.java
*
* Version:
*     $Id$: 5.0.2
*
* Revisions:
*     $Log$: 5.0.1
*/

import java.io.*;

/**
* The Player class compares the users guess with the 
* target word and provides the required pattern.
*
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/

public class Player  {

    // Declare all the instance variables
    int counter1 = 0;
    double floorNoOfLines;
    int flagCounter = 0;
    int vectorSize;
    char[] arr;
    String playerWord;
    char[] playerArray;
    char[] playerResult;

    /**
     * Initialize all the player values
     *
     * @param    counter                keeps track of the player number
     * @return   playerWord.length()    length of the target word
     */

    public int initializePlayerValues(int counter)throws FileNotFoundException  {
        arr = Word.readfromfile(counter);
        playerWord = String.valueOf(arr);

        // Store the picture for player 1 in a vector
        if(counter == 1){
            vectorSize = Picture.readfromfile1();
        }

        // Store the picture for player 2 in a vector
        else {
            vectorSize = Picture.readfromfile2();
        }
        
        playerArray = new char[playerWord.length()];
        playerResult = new char[playerWord.length()];

        for (int index = 0; index < playerWord.length(); index++){
            playerResult[index] = '.';
        }
        return playerWord.length(); 
    }

    /**
     * Read the values, populate the result array.
     *
     * @param    pNumber            player number
     * @return   flagCounter        counter to keep track of matched characters
     */

    public int letsPlay(int pNumber)throws FileNotFoundException {

    // Initializing the Player Array
    for (int index = 0; index < playerWord.length(); index++) {
        playerArray[index] = playerWord.charAt(index);
    }

    // Printing the Player Array
    for (int index = 0; index < playerWord.length(); index++) {
        System.out.print(playerArray[index]);
    }
    System.out.println("");

    // Print the previous guesses of player
    System.out.print("Previous Guesses: ");
    for (int index = 0; index < playerWord.length(); index++) {
      System.out.print(playerResult[index]);
    }
    System.out.println("");

    // Read player input
    System.out.println("Enter your guess: ");
    char player1Guess = Word.readUserInput();

    // Initialize the Player Result array with the correct characters
    for (int index = 0; index < playerWord.length(); index++){
        if(player1Guess == playerArray[index]){
          playerResult[index] = player1Guess;
          counter1++;
          break;
        }     
    }

    // Print the player's progress
    System.out.print("Your Guess: ");
    for (int index = 0; index < playerWord.length(); index++) {
      System.out.print(playerResult[index]);
    }
    System.out.println("");

    // Calculate the number of lines to be printed
    floorNoOfLines = PercentCalculation.percentCalc(counter1, playerWord.length(), vectorSize);

    // Display certain percentage of the image
    if (pNumber == 1) {
        Picture.printTheVector1(floorNoOfLines);
    }
    else {
        Picture.printTheVector2(floorNoOfLines);
    }
    flagCounter = 0;
    for (int index = 0; index < playerWord.length(); index++){
        if(playerResult[index] != '.') {
          flagCounter++;
        }
    }
    return flagCounter;
       
    }
}
