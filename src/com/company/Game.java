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

    public void StartGame(){

        Board gameBoard = new Board();

        for(int i=0; i< players.length; i++){

            Player new_player = new Player("Player" + String.valueOf(i), 500);
            players[i] = new_player;
            players[i].setCurrentPosition(0);

        }

        for(int i =0; i<this.numberOfTurns; i++){
            System.out.println("##### Current Turn: " + String.valueOf(i)+ " #####\n");

            for(int j=0; j<this.numberOfPlayers; j++){

                this.gameDice = new Die();
                int new_position = players[j].getCurrentPosition() +  this.gameDice.getDiceFace();
                gameBoard.movePlayer(players[j], new_position);
                System.out.println("\n-------------------------------------------\n");

            }

        }
        int currentPlayerMoneyAmount = -9000000;
        int playerIndex = 0;
        int max_number = 0;
        for(int i = 0; i < players.length; i++){
            currentPlayerMoneyAmount = players[i].getPlayerMoney().getMoneyAmount();
            if(currentPlayerMoneyAmount > max_number){
                max_number = currentPlayerMoneyAmount;
                playerIndex = i;
            }
        }

        System.out.println("\nWinner is:\n" + players[playerIndex].getName());
        System.out.println("\nMoney amount is: " + currentPlayerMoneyAmount);
        System.out.println("\nGAME IS OVER\n");
    }
}
