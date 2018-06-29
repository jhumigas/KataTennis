package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter name of the first player (Nadal):");
        String playerOne = br.readLine();
        if("".equals(playerOne)){
            playerOne = "Nadal";
        }
        System.out.print("Enter name of the first player(Djokovic):");
        String playerTwo = br.readLine();
        if("".equals(playerTwo)){
            playerTwo = "Djokovic";
        }
	    Game garros = new Game(playerOne, playerTwo);
	    garros.simulateGame(100);
    }
}
