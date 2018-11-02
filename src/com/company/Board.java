package com.company;

public class Board {

    Square[] squares;

    public Board(){

        this.squares = new Square[50];
        String[] square_name_array = {"House", "Land", "Hotel", "Tax Administration"};


        for(int i=0; i<squares.length; i++){


            if(square_name_array[i%4].equals("House")){


                Square new_square = new House();

                this.squares[i] = new_square;

                this.squares[i].setSquareName(square_name_array[i%4]+ String.valueOf(i));


            }else if (square_name_array[i%4].equals("Land")){
                Square new_square = new Land();

                this.squares[i] = new_square;

                this.squares[i].setSquareName(square_name_array[i%4]+ String.valueOf(i));
            }
            else if (square_name_array[i%4].equals("Hotel")){
                Square new_square = new Hotel();

                this.squares[i] = new_square;

                this.squares[i].setSquareName(square_name_array[i%4]+ String.valueOf(i));
            }else{

                Square new_square = new TaxAdministration();

                this.squares[i] = new_square;

                this.squares[i].setSquareName(square_name_array[i%4]+ String.valueOf(i));
            }
        }

    }
    public void movePlayer(Player player, int new_position){

        player.setCurrentPosition(new_position % 50);
        this.squares[player.getCurrentPosition()].setCurrentPlayerInPosition(player);
        System.out.println("+ Square is :" + squares[player.getCurrentPosition()].getSquareName() + "\n+ Player is :" + player.getName());
        this.squares[player.getCurrentPosition()].doAction(player);
    }

}
