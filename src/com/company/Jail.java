package com.company;

import java.util.ArrayList;

public class Jail extends Square {

    public Jail(){
        this.currentPlayersInPosition = new ArrayList<Player>();
    }
    @Override
    public void doAction(Player player_in_action) {

        player_in_action.setInPrison(true);
        System.out.println("-- Player: " + player_in_action.getName() + " is in prison now.") ;
        player_in_action.setPrisonTurnNumber(2);
    }

    @Override
    public void setSquareName(String s) {
        this.squareName = s;
    }

    @Override
    public ArrayList<Player> getCurrentPlayersInPosition() {
        return this.currentPlayersInPosition;
    }

    @Override
    public void setCurrentPlayersInPosition(Player player) {
        this.currentPlayersInPosition.add(player);

    }

    @Override
    public String getSquareName() {
        return this.squareName;
    }
}
