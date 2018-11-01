package com.company;

public class TaxAdministration extends Square {

    @Override
    public void doAction(Player player_in_action) {

        System.out.println("Tax Administration will cut 100 Dollars: " + player_in_action.getName() + "\n");
        Transaction transactionObject = new Transaction();
        transactionObject.UserPayment(player_in_action, 100);
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
