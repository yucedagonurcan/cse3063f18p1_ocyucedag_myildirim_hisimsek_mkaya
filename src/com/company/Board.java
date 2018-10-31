package com.company;

public class Board {

    Square[] squares;

    public Board(){

        this.squares = new Square[50];


        Die boardDie = new Die();


        for(int i=0; i< squares.length; i++){

            if (boardDie.getDiceFace()%2 == 0)
            {
                Square new_square = new Hotel();
                this.squares[i] = new_square;

                this.squares[i].setSquareName("Hotel"+ String.valueOf(i));
            }
            else{
                Square new_square = new House();
                this.squares[i] = new_square;

                this.squares[i].setSquareName("House"+ String.valueOf(i));
            }

        }


    }

    public void movePlayer(Player player, int new_position){

        player.setCurrentPosition(new_position);
        this.squares[player.getCurrentPosition()].setCurrentPlayerInPosition(player);
        System.out.print("Square is :" + squares[player.getCurrentPosition()].getSquareName() + ", Player is :" + player.getName() + "\n");
        this.squares[player.getCurrentPosition()].doAction(player);
    }

}
