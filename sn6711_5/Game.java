/*
* Game.java
*
* Version:
*     $Id$: 5.0.2
*
* Revisions:
*     $Log$: 5.0.1
*/


import java.io.FileNotFoundException;
import java.util.Scanner;


/**
* This program aims at studying and implementing different
* classes and methods.
*
* @author      Abhinav Ajit Menon
* @author      Srivenkatesh Shivadas Nair
*/

public class Game{

  static final Scanner readGuess = new Scanner(System.in);

  /**
    * The main program.
    *
    * @param    args    command line arguments (ignored)
    */ 
    
    public static void main (String [] args) throws FileNotFoundException {

        // Create 2 object for 2 different players.
        Player p1 = new Player();
        Player p2 = new Player();

        int wordLength1;
        int wordLength2;
        int flagCounter1 = -1;
        int flagCounter2 = -1 ;
        int playerCounter = 1;
        boolean playerflag = true;

        // Initialize the values and arrays for both the players
        wordLength1 = p1.initializePlayerValues(1);
        wordLength2 = p2.initializePlayerValues(2);

        // Loop for alternating between player 1 and player 2
        while(playerflag == true){

            // PLAYER 1
            if (playerCounter == 1) {
                System.out.print("Player 1:  ");
                flagCounter1 = p1.letsPlay(1);

                // Check if player 1 has guessed all the characters correctly
                if (flagCounter1 == wordLength1) {
                    System.out.println("Player 1 is the winner!!!");
                    playerflag = false;
                    break;
                }
            }
            playerCounter++;

            // PLAYER 2
            if (playerCounter == 2) {
                System.out.print("Player 2:  ");
                flagCounter2 = p2.letsPlay(2);

                // Check if player 2 has guessed all the characters correctly
                if (flagCounter2 == wordLength2) {
                    System.out.println("Player 2 is the winner!!!");
                    playerflag = false;
                    break;
                }
            }
            playerCounter--;

            // If any one player guesses the word correctly, break the loop
            if(flagCounter1 == wordLength1 || flagCounter2 == wordLength2){
                playerflag = false;
            }
        }    
    }
}