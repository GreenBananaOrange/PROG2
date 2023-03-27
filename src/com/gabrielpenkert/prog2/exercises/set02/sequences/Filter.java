package com.gabrielpenkert.prog2.exercises.set02.sequences;

public class Filter {
    public Sequence inputSequence;

    public Filter(Sequence inputSequence) {
        this.inputSequence = inputSequence;
    }

    public boolean condition(int index) {
        return false;
    }
}

class Evens extends Filter{
    public Evens(Sequence inputSequence) {
        super(inputSequence);
    }

    public boolean condition(int index) {
        return index % 2 == 0;
    }
}

class ZapMultiplies extends Filter {
    private int basisZahl; // die Zahl, um die es geht

    public ZapMultiplies(Sequence inputSequence, int basisZahl) {
        super(inputSequence);
        this.basisZahl = basisZahl;
    }

    @Override
    public boolean condition(int index) {
        return index % basisZahl != 0; // basisZahl laut Aufgabenbeispiel eine 3
    }
}