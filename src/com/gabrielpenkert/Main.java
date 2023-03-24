package com.gabrielpenkert;

import com.gabrielpenkert.prog2.exercises.set02.sequences.Naturals;
import com.gabrielpenkert.prog2.exercises.set02.sequences.Range;
import com.gabrielpenkert.prog2.exercises.set02.sequences.Sequence;
import com.gabrielpenkert.prog2.exercises.set02.sequences.SequenceTest;
import com.gabrielpenkert.prog2.lectureScripts.arraylistsExercise2;
import com.gabrielpenkert.prog2.exercises.set02.exercise2;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        // vergangener script der main-Methode:
        /*
        ConnectFourGame game = new ConnectFourGame();
        game.ConnectFourRun(); // run first application
        */
        /*
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
        */

        // Aktueller Code
        SequenceTest.println(new Naturals());
        /*
        Naturals nat = new Naturals();
        System.out.println();
        System.out.println(nat.hasNext(14));
        */
    }
}
