package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hotel extends Square{


    public Hotel(){
        this.currentPlayersInPosition = new ArrayList<Player>();
    }

    @Override
    public void setSquareName(String squareName) {
        this.squareName = squareName;
    }

    @Override
    public ArrayList<Player> getCurrentPlayersInPosition() {
        return currentPlayersInPosition;
    }
    @Override
    public void setCurrentPlayersInPosition(Player currentPlayerInPosition) {

        this.currentPlayersInPosition.add(currentPlayerInPosition);

    }
    @Override
    public String getSquareName() {
        return squareName;
    }

    @Override
    public void doAction(Player player_in_action) {

        if(this.owner_player == player_in_action){
            System.out.println("    --(Info) You already bought this Hotel");
        }
        else {


            // There is no owner so it can be for sale.
            if(owner_player == null){

                Scanner reader = new Scanner(System.in);
                System.out.println("    -Do you want to buy Hotel " + getSquareName() + " ? : ");
                Random rand = new Random();
                Boolean answer = rand.nextBoolean(); // Scans the next token of the input as an int.
                if(answer){

                    Transaction transactionObject = new Transaction();

                    System.out.println("       --Hotel: " + getSquareName() + " will be bought by : " + player_in_action.getName());
                    transactionObject.UserPayment(player_in_action, 400);

                    this.owner_player = player_in_action;

                }

            }
            // There is an owner, it can be for rent.
            else{
                    Transaction transactionObject = new Transaction();
                    System.out.println("    --Hotel: " + getSquareName() + " will be rented by : " + player_in_action.getName());
                    transactionObject.MoneyTransaction(player_in_action, owner_player, 200);

            }


        }

    }
}
