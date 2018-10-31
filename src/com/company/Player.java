package com.company;

public class Player {


    private Money playerMoney;
    private int prisonTurnNumber;
    private int currentPosition;
    private String name;


    public void setPlayerMoney(Money playerMoney) {
        this.playerMoney = playerMoney;
    }

    public void setPrisonTurnNumber(int prisonTurnNumber) {
        this.prisonTurnNumber = prisonTurnNumber;
    }



    public Money getPlayerMoney() {
        return playerMoney;
    }

    public int getPrisonTurnNumber() {
        return prisonTurnNumber;
    }

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

