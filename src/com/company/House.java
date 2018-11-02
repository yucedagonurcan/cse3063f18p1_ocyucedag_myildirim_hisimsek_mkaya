package com.company;

import java.util.Scanner;

public class House extends Square{


    @Override
    public void doAction(Player player_in_action) {
        if(this.owner_player == player_in_action || this.rented_player == player_in_action){
            System.out.println("    --(Info) You have already assets for this House");

        }
        else{

            // There is no owner so it can be for sale.
            if(owner_player == null){

                Scanner reader = new Scanner(System.in);  // Reading from System.in
                System.out.println("    -Do you want to buy House " + getSquareName() + " ? : ");
                String answer = reader.next(); // Scans the next token of the input as an int.
                if(answer.equals("Y") || answer.equals("y")){

                    Transaction transactionObject = new Transaction();
                    System.out.println("    --House: " + getSquareName() + " will be bought by : " + player_in_action.getName());
                    transactionObject.UserPayment(player_in_action, 200);
                    this.owner_player = player_in_action;

                }

            }
            // There is an owner, it can be for rent.
            else if (rented_player == null){

                Scanner reader = new Scanner(System.in);
                System.out.println("    -Do you want to rent House " + getSquareName() + " ? : ");
                String answer = reader.next();

                if(answer.equals("Y") || answer.equals("y")){

                    Transaction transactionObject = new Transaction();
                    System.out.println("    --House: " + getSquareName() + " will be rented by : " + player_in_action.getName());
                    transactionObject.MoneyTransaction(player_in_action, owner_player, 100);
                    this.rented_player = player_in_action;

                }
            }
            else{

                System.out.println("    --(Info) House: " + getSquareName() + " already rented by : " + rented_player.getName());

            }


        }

    }

    @Override
    public void setSquareName(String s) {
        this.squareName = s;
    }

    @Override
    public Player getCurrentPlayerInPosition() {
        return currentPlayerInPosition;
    }

    @Override
    public void setCurrentPlayerInPosition(Player player) {
        this.currentPlayerInPosition = player;
    }

    @Override
    public String getSquareName() {
        return squareName;
    }
}
