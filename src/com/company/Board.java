package com.company;

public class Board {

    Square[] squares;

    public Board(){

        this.squares = new Square[50];
        for(int i=0; i< squares.length; i++){

            Square new_square = new Square();
            this.squares[i] = new_square;

            this.squares[i].setSquareName("Square"+ String.valueOf(i));
        }


    }

    public void movePlayer(Player player, int new_position){

        player.setCurrentPosition(new_position);
        this.squares[player.getCurrentPosition()].setCurrentPlayerInPosition(player);
        System.out.print("Square is :" + squares[player.getCurrentPosition()].getSquareName() + ", Player is :" + player.getName() + "\n");

    }

}
