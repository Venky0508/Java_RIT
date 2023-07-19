/*
 * Hw12_2.java
 *
 * Version:
 *     $Id$: 12.0.1
 *
 * Revisions:
 *     $Log$: 12.0.5
 */

/**
 * The Hw12_2 program uses the concept of threads where n number of players play
 * a game for k rounds. The players sit in a circle and there is a light in the
 * middle. When the light turns red, the players will hit the button. The player
 * with the highest number of first hits after k rounds wins the game.
 *
 * @author      Abhinav Ajit Menon
 * @author      Srivenkatesh Shivadas Nair
 */

// Creating a subclass of Thread class
public class Hw12_2 extends Thread	{

    // Declaring instance and class variables
    private String info;
    static Object aObject = new Object();
    static int counter = 0;
    int firstBuzzerHitCounter = 0;
    static boolean flag = false;
    static int playerCount;

    // Parameterized constructor
    public Hw12_2(String info) {
        this.info = info;
    }

    /**
     * All the players wait for the button to turn red
     *
     * @param
     * @return   void
     */
    public void getReady() {
        // The threads sleep for a random amount of time
        try {
            sleep((int) (10 * Math.random()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // synchronized block
        synchronized (aObject) {
            counter++;
            // If all the players are ready(waiting), the button turns RED
            if (counter == playerCount) {
                new Hw12_2("button").start();
            }
            try {
                // The players wait one by one
                aObject.wait();
                // Condition to increase the counter for just the first player who hits the button
                if (flag == false) {
                    this.firstBuzzerHitCounter++;
                    flag = true;
                }
            } catch (IllegalMonitorStateException e) {
                System.err.println(info + ": IllegalMonitorStateException");
            } catch (InterruptedException e) {
                System.err.println(info + ": InterruptedException");
            }
        }
    }

    /**
     * The button turns RED
     *
     * @param
     * @return   void
     */
    public void hitTheButton() {
        // The threads sleep for a random amount of time
        try {
            sleep((int) (10 * Math.random()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // synchronized block
        synchronized (aObject) {
            try {
                // All the players hit the button in random order
                aObject.notifyAll();
            } catch (IllegalMonitorStateException e) {
                System.err.println(info + ": IllegalMonitorStateException");
            }
        }
    }

    /**
     * The run method
     *
     * @param
     * @return   void
     */
    public void run () {
        // The threads sleep for a random amount of time
        try {
            sleep((int) ( 10 * Math.random() ));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // synchronized block
        synchronized ( aObject )	{
            if ( ! info.equals("button") )
                getReady();
            else
                hitTheButton();
        }
    }

    /**
     * Store all the players in an array
     *
     * @param    playerNumber       index position of the array
     * @param    players            total number of players
     * @param    arr                Array of players
     * @return   void
     */
    public static Hw12_2[] populatePlayerArray(int playerNumber, int players, Hw12_2 arr[]){
        if (playerNumber == players){
            return arr;
        }
        else{
            arr[playerNumber] = new Hw12_2(Integer.toString(playerNumber));
            playerNumber++;
            populatePlayerArray(playerNumber, players, arr);
        }
       return arr;
    }

    /**
     * Start all the threads
     *
     * @param    playerIndex        index position of the array
     * @param    noOfPlayers        total number of players
     * @param    playerArr          Array of players
     * @param    allPlayersThread   Thread array of players
     * @return   void
     */
    public static void startThreads(int playerIndex, int noOfPlayers, Hw12_2[] playerArr, Thread[] allPlayersThread){
        if (playerIndex == noOfPlayers-1){
            allPlayersThread[playerIndex] = new Thread(playerArr[playerIndex]);
            allPlayersThread[playerIndex].start();
        }
        else{
            allPlayersThread[playerIndex] = new Thread(playerArr[playerIndex]);
            allPlayersThread[playerIndex].start();
            playerIndex++;
            startThreads(playerIndex, noOfPlayers, playerArr, allPlayersThread);
        }
    }

    /**
     * join all the threads
     *
     * @param    index              index position of the array
     * @param    noOfPlayers        total number of players
     * @param    allPlayersThread   Thread array of players
     * @return   void
     */
    public static void joinThreads(int index, int noOfPlayers, Thread[] allPlayersThread) throws InterruptedException {
        if(index == noOfPlayers-1){
            allPlayersThread[index].join();
        }
        else{
            allPlayersThread[index].join();
            index++;
            joinThreads(index, noOfPlayers, allPlayersThread);
        }
    }

    /**
     * Start all the threads
     *
     * @param    noOfPlayers        total number of players
     * @param    noOfRounds         total number of rounds
     * @param    playerArr          Array of players
     * @param    allPlayersThread   Thread array of players
     * @return   void
     */
    public static void pressTheButton(int noOfPlayers, int noOfRounds, Hw12_2[] playerArr, Thread[] allPlayersThread) throws InterruptedException {
        for(int roundIndex = 0; roundIndex < noOfRounds; roundIndex++) {
            startThreads(0, noOfPlayers, playerArr, allPlayersThread);
            joinThreads(0, noOfPlayers, allPlayersThread);
            flag = false;
            counter = 0;
        }
    }

    /**
     * print all the players number of first hits and the player that won
     *
     * @param    noOfPlayers        total number of players
     * @param    playerArr          Array of players
     * @return   void
     */
    public static void printFirstHitCount(int noOfPlayers, Hw12_2[] playerArr){
        int playerNumber = 0;
        Hw12_2 highestCounter = playerArr[0];
        // All the players and their total number of first hits
        for (int buzzerHitIndex = 0; buzzerHitIndex < noOfPlayers; buzzerHitIndex++){
            System.out.println("Player " + buzzerHitIndex + " has hit the button first: " + playerArr[buzzerHitIndex].firstBuzzerHitCounter);
            // Find the players with the maximum number of first hits
            if (highestCounter.firstBuzzerHitCounter < playerArr[buzzerHitIndex].firstBuzzerHitCounter){
                highestCounter = playerArr[buzzerHitIndex];
                playerNumber = buzzerHitIndex;
            }
        }
        System.out.println("Player " + playerNumber + " won, player has " + playerArr[playerNumber].firstBuzzerHitCounter + " first hits.");
    }

    /**
     * The main program.
     *
     * @param    args    command line arguments (ignored)
     */
    public static void main (String args []) throws InterruptedException {

        int noOfPlayers = Integer.parseInt(args[0]);
        int noOfRounds = Integer.parseInt(args[1]);
        playerCount = noOfPlayers;
        Hw12_2 playerArr[] = new Hw12_2[noOfPlayers];
        Thread allPlayersThread[] = new Thread[noOfPlayers];
        playerArr = populatePlayerArray(0, noOfPlayers, playerArr);
        pressTheButton(noOfPlayers, noOfRounds, playerArr, allPlayersThread);
        printFirstHitCount(noOfPlayers, playerArr);
    }
} // Hw12_2.java