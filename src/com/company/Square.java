package com.company;

public abstract class Square {

    public abstract void doAction(Player player_in_action);

    public abstract void setSquareName(String s);

    public abstract Player getCurrentPlayerInPosition();

    public abstract void setCurrentPlayerInPosition(Player player);

    public abstract String getSquareName();
}
