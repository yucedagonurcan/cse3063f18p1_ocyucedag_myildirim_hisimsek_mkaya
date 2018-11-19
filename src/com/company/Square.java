package com.company;

import java.util.ArrayList;

public abstract class Square {


    protected String squareName;
    protected Player owner_player;
    protected ArrayList<Player> currentPlayersInPosition ;


    public abstract void doAction(Player player_in_action);

    public abstract void setSquareName(String s);

    public abstract ArrayList<Player> getCurrentPlayersInPosition();

    public abstract void setCurrentPlayersInPosition(Player player);

    public abstract String getSquareName();
}
