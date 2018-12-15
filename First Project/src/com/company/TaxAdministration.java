package com.company;

import java.util.ArrayList;

public class TaxAdministration extends Square {


    public TaxAdministration(){
        this.currentPlayersInPosition = new ArrayList<Player>();
    }

    @Override
    public void doAction(Player player_in_action) {

        System.out.println("    --Tax Administration will cut 100 Dollars: " + player_in_action.getName());
        Transaction transactionObject = new Transaction();
        transactionObject.UserPayment(player_in_action, 100);
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
