package com.gabrielpenkert.prog2.exercises.set03;

public class TSP {
    private Journey rundreise;

    public TSP (Journey rundreise) {
        this.rundreise = rundreise;
    }

    public Journey getRundreise () {
        return rundreise;
    }

    public double berechneGesamtlänge () {
        // Dummy-Methode zur Berechnung der Gesamtlänge der Rundreise
        return 0.0;
    }

    public Journey findeOptimaleRundreise () {
        // Dummy-Methode zur Suche nach der optimalen Rundreise
        return rundreise;
    }
}
