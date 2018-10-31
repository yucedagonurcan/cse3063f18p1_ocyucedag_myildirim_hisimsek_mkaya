package com.company;

import java.util.Scanner;

public class Hotel extends Square{

    private String squareName;
    private Player owner_player;
    private Player rented_player;

    private Player currentPlayerInPosition;

    @Override
    public void setSquareName(String squareName) {
        this.squareName = squareName;
    }

    @Override
    public Player getCurrentPlayerInPosition() {
        return currentPlayerInPosition;
    }
    @Override
    public void setCurrentPlayerInPosition(Player currentPlayerInPosition) {
        this.currentPlayerInPosition = currentPlayerInPosition;
    }
    @Override
    public String getSquareName() {
        return squareName;
    }

    @Override
    public void doAction(Player player_in_action) {
        // There is no owner so it can be for sale.
        if(owner_player == null){

            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("Do you want to buy Hotel " + getSquareName() + " ? : ");
            String answer = reader.next(); // Scans the next token of the input as an int.
            if(answer.equals("Y") || answer.equals("y")){

                System.out.println("Hotel: " + getSquareName() + " will be bought by : " + player_in_action.getName() + "\n");
                owner_player = player_in_action;

            }

        }
        // There is an owner, it can be for rent.
        else if (rented_player == null){

            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("Do you want to rent Hotel " + getSquareName() + " ? : ");
            String answer = reader.next(); // Scans the next token of the input as an int.
            if(answer.equals("Y") || answer.equals("y")){

                System.out.println("Hotel: " + getSquareName() + " will be rented by : " + player_in_action.getName() + "\n");
                rented_player = player_in_action;

            }

        }
    }
}
