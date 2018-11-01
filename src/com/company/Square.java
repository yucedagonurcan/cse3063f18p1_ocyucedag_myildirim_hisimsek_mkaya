package com.company;

public abstract class Square {


    protected String squareName;
    protected Player owner_player;
    protected Player rented_player;
    protected Player currentPlayerInPosition;


    public abstract void doAction(Player player_in_action);

    public abstract void setSquareName(String s);

    public abstract Player getCurrentPlayerInPosition();

    public abstract void setCurrentPlayerInPosition(Player player);

    public abstract String getSquareName();
}
