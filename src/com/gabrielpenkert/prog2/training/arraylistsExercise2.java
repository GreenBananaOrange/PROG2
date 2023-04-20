package com.gabrielpenkert.prog2.training;

import java.util.ArrayList;

public class arraylistsExercise2 {
    public ArrayList<String> cars = new ArrayList<>();
    public void addItem (String input) {
        cars.add(input);
        System.out.println(input + " was added.");
        status();
        System.out.println();
    }

    public void status () {
        System.out.println("Status: " + cars);
    }
}
