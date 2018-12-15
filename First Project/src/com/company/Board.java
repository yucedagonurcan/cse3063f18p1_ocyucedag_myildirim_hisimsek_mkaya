package com.company;

public class Board {
    Square[] squares;
    public Board(){
        this.squares = new Square[50];
        String[] square_name_array = {"House", "Land", "Hotel", "Tax Administration", "Jail"};
        for(int i=0; i<squares.length; i++){

            if(square_name_array[i%5].equals("House")){


                Square new_square = new House();

                this.squares[i] = new_square;

                this.squares[i].setSquareName(square_name_array[i%5]+ String.valueOf(i));


            }else if (square_name_array[i%5].equals("Land")){
                Square new_square = new Land();

                this.squares[i] = new_square;

                this.squares[i].setSquareName(square_name_array[i%5]+ String.valueOf(i));
            }
            else if (square_name_array[i%5].equals("Hotel")){
                Square new_square = new Hotel();

                this.squares[i] = new_square;

                this.squares[i].setSquareName(square_name_array[i%5]+ String.valueOf(i));
            }else if (square_name_array[i%5].equals("Tax Administration")){

                Square new_square = new TaxAdministration();

                this.squares[i] = new_square;

                this.squares[i].setSquareName(square_name_array[i%5]+ String.valueOf(i));
            }else{
                Square new_square = new Jail();

                this.squares[i] = new_square;

                this.squares[i].setSquareName(square_name_array[i%5]+ String.valueOf(i));

            }
        }
    }
    public boolean MovePlayer(Player player, int new_position){

        // If player is not in a prison.
        if(!player.getInPrison()){

            player.setCurrentPosition(new_position % 50);
            this.squares[player.getCurrentPosition()].setCurrentPlayersInPosition(player);
            System.out.println("+ Square is :" + squares[player.getCurrentPosition()].getSquareName() + "\n+ Player is :" + player.getName());
            this.squares[player.getCurrentPosition()].doAction(player);

            // If player is broke after the action.
            if(GetBrokeState(player)) {

                System.out.println("-- Player: " + player.getName() + " is broke. \n--- We are kicking out.") ;
                return true;
            }
        }
        else{
            switch (player.getPrisonTurnNumber()) {
                // If the player has to be in prison for this turn.
                case 1: player.setPrisonTurnNumber(player.getPrisonTurnNumber() - 1);
                        player.setInPrison(false);
                        System.out.println("-- Player: " + player.getName() + " is got off from prison.") ;
                        break;
                // If player will got off the prison in the next turn.
                case 2: player.setPrisonTurnNumber(player.getPrisonTurnNumber() - 1);
                        System.out.println("-- Player: " + player.getName() + " is still in prison.") ;
                        break;
            }
        }
        return false;
    }
    public boolean GetBrokeState(Player player_in_check ){

        return (player_in_check.getPlayerMoney().getMoneyAmount() < 0);
    }

}