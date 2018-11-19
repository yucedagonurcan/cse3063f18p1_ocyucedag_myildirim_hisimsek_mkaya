package com.company;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class House extends Square{

    public House(){
        this.currentPlayersInPosition = new ArrayList<Player>();
    }
    @Override
    public void doAction(Player player_in_action) {
        if(this.owner_player == player_in_action ){
            System.out.println("    --(Info) You already bought this House");

        }
        else{

            // There is no owner so it can be for sale.
            if(owner_player == null){

                Scanner reader = new Scanner(System.in);  // Reading from System.in
                System.out.println("    -Do you want to buy House " + getSquareName() + " ? : ");

                Random rand = new Random();
                Boolean answer = rand.nextBoolean(); // Scans the next token of the input as an int.
                if(answer){

                    Transaction transactionObject = new Transaction();
                    System.out.println("    --House: " + getSquareName() + " will be bought by : " + player_in_action.getName());
                    transactionObject.UserPayment(player_in_action, 200);
                    this.owner_player = player_in_action;

                }
                else{
                    System.out.println("    --House: " + getSquareName() + " won't be bought by : " + player_in_action.getName() + "\n    --- Player Rejected...");

                }

            }
            // There is an owner, it can be for rent.
            else{
                Transaction transactionObject = new Transaction();
                System.out.println("    --House: " + getSquareName() + " will be rented by : " + player_in_action.getName());
                transactionObject.MoneyTransaction(player_in_action, owner_player, 100);
            }
        }

    }

    @Override
    public void setSquareName(String s) {
        this.squareName = s;
    }

    @Override
    public ArrayList<Player> getCurrentPlayersInPosition() {
        return currentPlayersInPosition;
    }

    @Override
    public void setCurrentPlayersInPosition(Player player) {
        this.currentPlayersInPosition.add(player);
    }

    @Override
    public String getSquareName() {
        return squareName;
    }
}
