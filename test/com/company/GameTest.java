package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void whoWonTest() {
        Game tester = new Game("One", "Two");
        tester.setPointsPlayerOne(2);
        assertEquals(-1,tester.whoWon());
        tester.setPointsPlayerOne(5);
        assertEquals(0,tester.whoWon());
        tester.setPointsPlayerOne(4);
        tester.setPointsPlayerTwo(5);
        assertEquals(-1,tester.whoWon());
    }

    @Test
    public void pointsToScoreTest() {
        Game tester = new Game();
        tester.setPoints(3,0);
        assertEquals("love",Game.pointsToScore(tester.getPointsPlayerTwo()));
        assertEquals("forty",Game.pointsToScore(tester.getPointsPlayerOne()));
    }

    @Test
    public void scoreIsDeuceTest() {
        Game tester = new Game();
        tester.setPoints(2, 2);
        assertTrue(!tester.isScoreDeuce());
        tester.setPoints(3, 3);
        assertTrue(tester.isScoreDeuce());

    }

    @Test
    public void whichPlayerhasAnAdvantageTest() {
        Game tester = new Game("One", "Two");
        tester.setPointsPlayerOne(4);
        assertEquals(-1, tester.whichPlayerhasAnAdvantage());
        tester.setPointsPlayerTwo(6);
        assertEquals(1, tester.whichPlayerhasAnAdvantage());
    }


}