package com.company;

import java.util.List;

/**
 *  Proposition for the KataTennis
 */
public class Game {

    private String playerOne;
    private String playerTwo;
    private int countsOne;
    private int countsTwo;
    private int pointsOne;
    private int pointsTwo;
    private List<Integer> pointsValues = List.of(0, 15, 30, 40);

    /**
     * Simple Getter
     * @return playerOne name
     */
    public String getPlayerOne() {
        return playerOne;
    }

    /**
     * Set playerOne's name
     * @param playerOne New name of playerOne
     */
    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    /**
     *
     * @return playerOne's points
     */
    public int getCountsPlayerOne(){
        return countsOne;
    }

    /**
     *
     * @return playerTwo's points
     */
    public int getCountsPlayerTwo(){
        return countsTwo;
    }

    /**
     * Set both of the points of the players
     * @param countsOne Player's one points
     * @param countsTwo Players's two points
     */
    public void setCounts(int countsOne, int countsTwo){
        this.countsOne = countsOne;
        this.countsTwo = countsTwo;
    }

    /**
     * Set points of playerOne
     * @param points New values of points
     */
    public void setCountsPlayerOne(int points) {
        countsOne = points;
    }

    /**
     * Set points of playerTwo
     * @param points New values of points
     */
    public void setCountsPlayerTwo(int points) {
        countsTwo = points;
    }

    public int getPointsPlayerOne(){
        updateScores();
        return this.pointsOne;
    }

    public int getPointsPlayerTwo(){
        updateScores();
        return this.pointsTwo;
    }

    /**
     * Default constructor
     * It will set the names of players by default
     * resp. to Player1 and Player2
     * And it will also initiate the points to 0
     */
    public Game(){
        this.playerOne = "Player1";
        this.playerTwo = "Player2";
        this.initiateCounts();
    }

    /**
     * Initiate game with two player names and initial points of 0
     * @param playerOne Name of the first player
     * @param playerTwo Name of the second player
     */
    public Game(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.initiateCounts();
    }

    /**
     * Initiate points to 0
     */
    public void initiateCounts(){
        this.countsOne = 0;
        this.countsTwo = 0;
    }

    /**
     * Return the index of the player who one i.e 0 for PlayerOne, 1 for PlayerTwo
     * If the game is not yet over, return -1 by default
     * @return 0, 1 or -1
     */
    public int whoWon(){
        int winner;
        if(this.isTheGameOver()){
            winner = countsOne > countsTwo ? 0:1;
            String winnerName = winner==0?this.playerOne:this.playerTwo;
            System.out.println("Woooow, player "+ winnerName + " is the winner.");
        }else{
            winner = -1;
            System.out.println("No one has won the game yet.");
        }
        return winner;
    }

    /**
     * Check if the game is over
     * @return boolean True if the game is over
     */
    public boolean isTheGameOver(){
        return (this.countsOne >=4 || this.countsTwo>=4) && Math.abs(this.countsOne - this.countsTwo) >=2;
    }

    /**
     * Set the ball winner i.e after an exchange of the ball
     * who should get the points.
     * It increment the points of the winner
     * @param choice True if playerOne won
     */
    public void setBallWinner(boolean choice){
        if(choice){
            countsOne++;
            System.out.println("Player " + playerOne + " has won.");
        }else{
            countsTwo++;
            System.out.println("Player " + playerTwo + " has won.");
        }
    }


    public void printScores(){
        if(countsOne >= 3 && this.countsTwo >=3){
            if(isScoreDeuce()){
                System.out.println("Score is: ADV -- ADV (deuce)");
            }else{
                int advPlayer = whichPlayerhasAnAdvantage();
                if(advPlayer  == 0){
                    System.out.println("Score is: ADV -- X");
                }else{
                    System.out.println("Score is: X -- ADV");
                }
            }
        }else{
            if(!isTheGameOver()) {
                System.out.println("Score is: " + pointsToScore(countsOne) + " -- " + pointsToScore(countsTwo));
            }
        }
    }

    public void updateScores(){
        if(countsOne >= 3 && this.countsTwo >=3){
            this.pointsOne = 40;
            this.pointsTwo = 40;
        }else{
            if(!isTheGameOver()) {
                this.pointsOne = countsOne>=0? pointsValues.get(countsOne): 0;
                this.pointsTwo = countsTwo>=0? pointsValues.get(countsTwo): 0;
            }
        }
    }

    /**
     * Map points of a single player to score love, fifteen and thirty and forty;
     * @param numCounts
     * @return Name of the score (as described in wikipedia)
     */
    public static String pointsToScore(int numCounts){
        String score;
        switch(numCounts) {
            case 0:
                score = "love";
                break;

            case 1:
                score = "fifteen";
                break;

            case 2:
                score = "thirty";
                break;
            case 3:
                score = "forty";
                break;

            default :
                score = "Undefined";
        }
        return score;
    }

    /**
     * Check if score are equal and above three points
     * @return True
     */
    public boolean isScoreDeuce(){
        return countsOne>=3 && countsTwo>=3 && countsOne==countsTwo;
    }

    /**
     * Check if there any player who has an advantage
     * @return 0 or 1 if any of the player has an advantage, -1 otherwise
     */
    public int whichPlayerhasAnAdvantage (){
        int playerNum;
        if(countsOne>=3 && countsTwo>=3 && countsOne!=countsTwo){
            playerNum = countsOne>countsTwo ? 0:1;
            String playerName = playerNum==0? playerOne:playerTwo;
        }else{
            playerNum = -1;
        }
        return playerNum;
    }

    /**
     * Play a game with random output
     * @param n Number of maximum rounds in the game
     */
    public void simulateGame(int n){
        int j=0;
        while(this.whoWon()<0 && j<n){
            System.out.println(j + " -----------------------------------");
            setBallWinner(Math.random()>0.5);
            this.printScores();
            j++;
        }
    }
}
