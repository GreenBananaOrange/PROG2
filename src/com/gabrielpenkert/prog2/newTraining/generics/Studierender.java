package com.gabrielpenkert.prog2.newTraining.generics;

public class Studierender extends com.gabrielpenkert.prog2.newTraining.generics.Person {
    public Studierender(String name, int matrikel) {
        super(name);
        this.matrikel = matrikel;
    }

    int matrikel;
}
