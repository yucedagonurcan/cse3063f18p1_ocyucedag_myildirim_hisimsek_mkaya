package com.company;

public class Square {



    private String squareName;


    public void setSquareName(String squareName) {
        this.squareName = squareName;
    }

    private Player currentPlayerInPosition;

    public Player getCurrentPlayerInPosition() {
        return currentPlayerInPosition;
    }

    public void setCurrentPlayerInPosition(Player currentPlayerInPosition) {
        this.currentPlayerInPosition = currentPlayerInPosition;
    }
    public String getSquareName() {
        return squareName;
    }
}
