package com.company;

import java.util.ArrayList;

public class Game {

    private int numberOfPlayers;
    private int numberOfTurns;
    private Die gameDice;
    private ArrayList<Player> players;


    public Game(int numberOfPlayers, int numberOfTurns){
        this.numberOfPlayers = numberOfPlayers;
        this.numberOfTurns   = numberOfTurns;
        this.players = new ArrayList<Player>();
    }

    public void StartGame(){

        Board gameBoard = new Board();

        for(int i=0; i< this.numberOfPlayers; i++){

            Player new_player = new Player("Player" + String.valueOf(i), 1500);
            players.add(new_player);
            players.get(i).setCurrentPosition(0);
        }
        for(int i =0; i<this.numberOfTurns; i++){
            System.out.println("##### Current Turn: " + String.valueOf(i)+ " #####\n");

            for(int j=0; j<this.numberOfPlayers; j++){

                this.gameDice = new Die();
                int new_position = players.get(j).getCurrentPosition() +  this.gameDice.getDiceFace();
                boolean broke = gameBoard.MovePlayer(players.get(j), new_position);
                if(broke){
                    KickPlayerOut(players.get(j));
                }
                System.out.println("\n-------------------------------------------\n");
            }
        }

        GameOver();

    }

    public void KickPlayerOut(Player player_to_kick_out){
        players.remove(player_to_kick_out);
        this.numberOfPlayers--;
        System.out.println("\nNumber of players left:" + this.numberOfPlayers);
        if (this.numberOfPlayers == 1){
            GameOver();
            return;
        }


    }
    public void GameOver(){
        int currentPlayerMoneyAmount = -9000000;
        int playerIndex = 0;
        int max_number = 0;
        for(int i = 0; i < players.size(); i++){
            currentPlayerMoneyAmount = players.get(i).getPlayerMoney().getMoneyAmount();
            if(currentPlayerMoneyAmount > max_number){
                max_number = currentPlayerMoneyAmount;
                playerIndex = i;
            }
        }
        System.out.println("\n####################################################\nGame is over.\n");
        System.out.println("Winner is: " + players.get(playerIndex).getName());
        System.out.println("\n + Money amount is: " + currentPlayerMoneyAmount);

        System.exit(0);

    }
}
