package com.gabrielpenkert;

import com.gabrielpenkert.exercise1.ConnectFourGame;
import com.gabrielpenkert.exercisesLive.arraylistsExercise;
import com.gabrielpenkert.exercisesLive.arraylistsExercise2;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        // ConnectFourGame game = new ConnectFourGame();
        // game.ConnectFourRun(); // run first application
        arraylistsExercise2 test = new arraylistsExercise2();
        test.addItem("Volvo");
        test.addItem("BMW");
        test.addItem("Ford");
        test.addItem("Mazda");
        test.status();

        Iterator<String> it = test.cars.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
