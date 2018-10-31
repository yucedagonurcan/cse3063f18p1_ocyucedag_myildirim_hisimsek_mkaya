package com.company;

import java.util.Scanner;

public class Land extends Square {



    @Override
    public void doAction(Player player_in_action) {

        // There is no owner so it can be for sale.
        if(owner_player == null){

            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("Do you want to buy Land " + getSquareName() + " ? : ");
            String answer = reader.next(); // Scans the next token of the input as an int.
            if(answer.equals("Y") || answer.equals("y")){
                Transaction transactionObject = new Transaction();

                System.out.println("Land: " + getSquareName() + " will be bought by : " + player_in_action.getName() + "\n");
                transactionObject.UserPayment(player_in_action, 100);

                owner_player = player_in_action;

            }

        }
        // There is an owner, it can be for rent.
        else if (rented_player == null){

            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("Do you want to rent Land " + getSquareName() + " ? : ");
            String answer = reader.next(); // Scans the next token of the input as an int.
            if(answer.equals("Y") || answer.equals("y")){
                Transaction transactionObject = new Transaction();

                System.out.println("Land: " + getSquareName() + " will be rented by : " + player_in_action.getName() + "\n");
                transactionObject.MoneyTransaction(player_in_action, owner_player, 100);

                rented_player = player_in_action;



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
        return this.squareName;
    }
}
