package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    System.out.print("Hello, you are in !!\n");

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter numberOfPlayers: ");
        int numberOfPlayers = 3; //reader.nextInt(); // Scans the next token of the input as an int.
        System.out.println("Enter numberOfTurns: ");
        int numberOfTurns = 6;//reader.nextInt(); // Scans the next token of the input as an int.


        Game newGame = new Game(numberOfPlayers= numberOfPlayers, numberOfTurns=numberOfTurns);
        newGame.StartGame();

    }
}
