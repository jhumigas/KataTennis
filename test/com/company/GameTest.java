package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void whoWonTest() {
        Game tester = new Game("One", "Two");
        tester.setCountsPlayerOne(2);
        assertEquals(-1,tester.whoWon());
        tester.setCountsPlayerOne(5);
        assertEquals(0,tester.whoWon());
        tester.setCountsPlayerOne(4);
        tester.setCountsPlayerTwo(5);
        assertEquals(-1,tester.whoWon());
    }

    @Test
    public void pointsToScoreTest() {
        Game tester = new Game();
        tester.setCounts(3,0);
        assertEquals("love",Game.pointsToScore(tester.getCountsPlayerTwo()));
        assertEquals("forty",Game.pointsToScore(tester.getCountsPlayerOne()));
    }

    @Test
    public void scoreIsDeuceTest() {
        Game tester = new Game();
        tester.setCounts(2, 2);
        assertTrue(!tester.isScoreDeuce());
        tester.setCounts(3, 3);
        assertTrue(tester.isScoreDeuce());

    }

    @Test
    public void whichPlayerhasAnAdvantageTest() {
        Game tester = new Game("One", "Two");
        tester.setCountsPlayerOne(4);
        assertEquals(-1, tester.whichPlayerhasAnAdvantage());
        tester.setCountsPlayerTwo(6);
        assertEquals(1, tester.whichPlayerhasAnAdvantage());
    }

    @Test public void printScores(){
        Game tester = new Game();
        tester.setCounts(6, 7);
        tester.printScores();
        tester.setCounts(0, 0);
        tester.printScores();
        tester.setCounts(-1, -1);
        tester.printScores();
    }

    @Test public void updateScores(){
        Game tester = new Game();
        tester.setCounts(7,8);
        tester.updateScores();
        assertEquals(40, tester.getPointsPlayerOne());
        assertEquals(40, tester.getPointsPlayerTwo());
        tester.setCounts(0,3);
        assertEquals(0, tester.getPointsPlayerOne());
        assertEquals(40, tester.getPointsPlayerTwo());
        tester.setCounts(-1,-1);
        assertEquals(0, tester.getPointsPlayerOne());
        assertEquals(0, tester.getPointsPlayerTwo());
    }


}