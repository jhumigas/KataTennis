package com.company;

/**
 *  Proposition for the KataTennis
 */
public class Game {

    private String playerOne;
    private String playerTwo;
    private int pointsOne;
    private int pointsTwo;
    private int kataPointsOne;
    private int kataPointsTwo;

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
    public int getPointsPlayerOne(){
        return pointsOne;
    }

    /**
     *
     * @return playerTwo's points
     */
    public int getPointsPlayerTwo(){
        return pointsTwo;
    }

    /**
     * Set both of the points of the players
     * @param pointsOne Player's one points
     * @param pointsTwo Players's two points
     */
    public void setPoints(int pointsOne, int pointsTwo){
        this.pointsOne = pointsOne;
        this.pointsTwo = pointsTwo;
    }

    /**
     * Set points of playerOne
     * @param points New values of points
     */
    public void setPointsPlayerOne(int points) {
        pointsOne = points;
    }

    /**
     * Set points of playerTwo
     * @param points New values of points
     */
    public void setPointsPlayerTwo(int points) {
        pointsTwo = points;
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
        this.initiatePoints();
    }

    /**
     * Initiate game with two player names and initial points of 0
     * @param playerOne Name of the first player
     * @param playerTwo Name of the second player
     */
    public Game(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.initiatePoints();
    }

    /**
     * Initiate points to 0
     */
    public void initiatePoints(){
        this.pointsOne = 0;
        this.pointsTwo = 0;
    }

    /**
     * Return the index of the player who one i.e 0 for PlayerOne, 1 for PlayerTwo
     * If the game is not yet over, return -1 by default
     * @return 0, 1 or -1
     */
    public int whoWon(){
        int winner;
        if(this.isTheGameOver()){
            winner = pointsOne > pointsTwo ? 0:1;
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
        return (this.pointsOne >=4 || this.pointsTwo>=4) && Math.abs(this.pointsOne - this.pointsTwo) >=2;
    }

    /**
     * Set the ball winner i.e after an exchange of the ball
     * who should get the points.
     * It increment the points of the winner
     * @param choice True if playerOne won
     */
    public void setBallWinner(boolean choice){
        if(choice){
            pointsOne++;
            System.out.println("Player " + playerOne + " has won.");
        }else{
            pointsTwo++;
            System.out.println("Player " + playerTwo + " has won.");
        }
    }
    

    public void printScores(){
        if(pointsOne >= 3 && this.pointsTwo >=3){
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
                System.out.println("Score is: " + pointsToScore(pointsOne) + " -- " + pointsToScore(pointsTwo));
            }
        }
    }

    /**
     * Map points of a single player to score love, fifteen and thirty and forty;
     * @param numPoints
     * @return Name of the score (as described in wikipedia)
     */
    public static String pointsToScore(int numPoints){
        String score;
        switch(numPoints) {
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
        return pointsOne>=3 && pointsTwo>=3 && pointsOne==pointsTwo;
    }

    /**
     * Check if there any player who has an advantage
     * @return 0 or 1 if any of the player has an advantage, -1 otherwise
     */
    public int whichPlayerhasAnAdvantage (){
        int playerNum;
        if(pointsOne>=3 && pointsTwo>=3 && pointsOne!=pointsTwo){
            playerNum = pointsOne>pointsTwo ? 0:1;
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
