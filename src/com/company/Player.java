package com.company;

public class Player {


    private Money playerMoney;


    private boolean inPrison;
    private int prisonTurnNumber;
    private int currentPosition;
    private String name;


    public void setPlayerMoney(Money playerMoney) {
        this.playerMoney = playerMoney;
    }
    public void setPlayerMoneyAmount(int playerMoneyAmount) {
        this.playerMoney.setMoneyAmount(playerMoneyAmount);
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
        this.inPrison = false;
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

    public boolean getInPrison() {
        return inPrison;
    }

    public void setInPrison(boolean inPrison) {
        this.inPrison = inPrison;
    }
}

