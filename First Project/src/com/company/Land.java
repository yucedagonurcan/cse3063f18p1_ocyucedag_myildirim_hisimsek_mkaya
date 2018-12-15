package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Land extends Square {

    public Land(){
        this.currentPlayersInPosition = new ArrayList<Player>();
    }
    @Override
    public void doAction(Player player_in_action) {

        if(this.owner_player == player_in_action){
            System.out.println("    --(Info) You already bought this Land");
        }
        else{
            // There is no owner so it can be for sale.
            if(this.owner_player == null){

                Scanner reader = new Scanner(System.in);  // Reading from System.in
                System.out.println("    -Do you want to buy Land " + getSquareName() + " ? : ");
                Random rand = new Random();
                Boolean answer = rand.nextBoolean(); // Scans the next token of the input as an int.
                if(answer){

                    Transaction transactionObject = new Transaction();

                    System.out.println("    --Land: " + getSquareName() + " will be bought by : " + player_in_action.getName());
                    transactionObject.UserPayment(player_in_action, 100);

                    this.owner_player = player_in_action;

                }
            }
            // There is an owner, it can be for rent.
            else{
                Transaction transactionObject = new Transaction();
                System.out.println("    --Land: " + getSquareName() + " will be rented by : " + player_in_action.getName());
                transactionObject.MoneyTransaction(player_in_action, owner_player, 50);
            }
        }
    }

    @Override
    public void setSquareName(String s) {
        this.squareName = s;
    }

    @Override
    public ArrayList<Player> getCurrentPlayersInPosition() {
        return this.currentPlayersInPosition;
    }

    @Override
    public void setCurrentPlayersInPosition(Player player) {
        this.currentPlayersInPosition.add(player);
    }

    @Override
    public String getSquareName() {
        return this.squareName;
    }
}
