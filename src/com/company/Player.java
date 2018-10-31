package com.company;

public class Player {



    private String name;
    private Money playerMoney;
    private int prisonTurnNumber;
    private int currentPosition;


    public Player(String name, int playerMoneyAmount){

        this.name = name;
        this.playerMoney = new Money(playerMoneyAmount);
        this.playerMoney.setMoneyAmount(playerMoneyAmount);
    }



    public int getCurrentPosition() {
        return currentPosition;
    }
    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

