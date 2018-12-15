package com.company;
import java.util.Random;


public class Die {





    public int getDiceFace(){

        Random rand = new Random();
        return rand.nextInt(6) + rand.nextInt(6) + 2;
    }
}
