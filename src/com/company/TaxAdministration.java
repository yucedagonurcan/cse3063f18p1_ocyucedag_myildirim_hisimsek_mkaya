package com.company;

public class TaxAdministration extends Square {

    @Override
    public void doAction(Player player_in_action) {


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
