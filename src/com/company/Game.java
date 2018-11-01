package com.company;

public class Game {

    private int numberOfPlayers;
    private int numberOfTurns;
    private Die gameDice;
    private Player[] players;


    public Game(int numberOfPlayers, int numberOfTurns){
        this.numberOfPlayers = numberOfPlayers;
        this.numberOfTurns   = numberOfTurns;
        this.players = new Player[numberOfPlayers];
    }
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void StartGame(){

        Board gameBoard = new Board();

        for(int i=0; i< players.length; i++){

            Player new_player = new Player("Player" + String.valueOf(i), 500);
            players[i] = new_player;
            players[i].setCurrentPosition(0);

        }

        for(int i =0; i<this.numberOfTurns; i++){
            System.out.print("Current Turn: " + String.valueOf(i)+ "\n");
            for(int j=0; j<this.numberOfPlayers; j++){

                this.gameDice = new Die();
                int new_position = players[j].getCurrentPosition() +  this.gameDice.getDiceFace();
                gameBoard.movePlayer(players[j], new_position);
            }

        }



    }
}
