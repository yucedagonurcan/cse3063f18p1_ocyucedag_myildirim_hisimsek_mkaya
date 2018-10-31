package com.company;

import java.util.Optional;

public class Transaction {

    private Player player1;
    private Player player2;
    private int moneyAmount;

    public void UserPayment(Player player1,  int moneyAmount){

        this.player1 = player1;
        this.moneyAmount = moneyAmount;

        int user_current_money_amount = this.player1.getPlayerMoney().getMoneyAmount();
        this.player1.getPlayerMoney().setMoneyAmount(user_current_money_amount- moneyAmount);
        System.out.println("User has a new money amount: !" + player1.getName() + " : " + player1.getPlayerMoney().getMoneyAmount());

    }
    public void MoneyTransaction(Player player1, Player player2, int moneyAmount){
        this.player1 = player1;
        this.player2 = player2;
        this.moneyAmount = moneyAmount;

        //Get player1 s money and substract it with moneyAmount. Updates new player1 s money
        int current_money_amount_of_player1 = this.player1.getPlayerMoney().getMoneyAmount();
        this.player1.getPlayerMoney().setMoneyAmount(current_money_amount_of_player1 - moneyAmount);

        //Get player2 s money and substract it with moneyAmount. Updates new player2 s money
        int current_money_amount_of_player2 = this.player2.getPlayerMoney().getMoneyAmount();
        this.player2.getPlayerMoney().setMoneyAmount(current_money_amount_of_player2 + moneyAmount);

        System.out.println("User has a new money amount: !" + player1.getName() + " : " + player1.getPlayerMoney().getMoneyAmount());
        System.out.println("User has a new money amount: !" + player2.getName() + " : " + player2.getPlayerMoney().getMoneyAmount());


    }
}
