package com.gabrielpenkert.prog2.exercises.set03;

import java.util.Arrays;

public class TSP {
    public Journey journey;

    public TSP (Journey journey) {
        this.journey = journey;
    }

    public Journey getJourney() {
        return journey;
    }

    public double totalLength() {
        // Berechnung der Gesamtlaenge der Rundreise
        return 0.0;
    }

    public static double getLengthOfTwoCoordinates (int x1, int y1, int x2, int y2) {
        double length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return length;
    }

    public static void greedyAlgorithmUnfunctional (Journey tsp1) {
        String[] usedPositions = new String[tsp1.places.size()];
        int length = tsp1.places.size();
        double courseLength = 0;
        // anfangsvariable/-ort definieren
        for (int i = 0; i < length; i++) {
            String ort = tsp1.getOrtName(i); // aktueller knoten
            boolean isUsed = false;
            for (int iterate = 0; iterate < length; iterate++) { // main-index-letter bereits vorgekommen?
                if (ort == usedPositions[iterate])
                    isUsed = true;
            }

            for (int index = i; index < length; index++) {
                String shortest = " ";
                double valueOfShortest = Double.MAX_VALUE;
                if (!isUsed) {
                    double value = getLengthOfTwoCoordinates(tsp1.getOrtX(i), tsp1.getOrtY(i), tsp1.getOrtX(index), tsp1.getOrtX(index));
                    if (shortest == " " || value < valueOfShortest) { // falls noch kein ort verglichen wurde || falls ort kleiner als ein anderer ort
                        valueOfShortest = value;
                        shortest = tsp1.getOrtName(index);
                    }
                    // System.out.println("tsp1.getOrtX(i): " + tsp1.getOrtX(i) + " tsp1.getOrtY(i): " + tsp1.getOrtY(i) + " tsp1.getOrtX(index): "  + tsp1.getOrtX(index) + " tsp1.getOrtY(index): " + tsp1.getOrtX(index));
                }
                courseLength += valueOfShortest;
                usedPositions[i] = shortest; // somit nicht mehr zur verfuegung
            }
        }
        System.out.println("Used positions: " + Arrays.toString(usedPositions));
        System.out.println("Value of shortest course: " + courseLength);
    }
    public static void greedyAlgorithmUnfunctional2 (Journey tsp1) {
        int length = tsp1.places.size();
        String[] usedPlaces = new String[length];

        String startNode = tsp1.getOrtName(0);
        double valueOfShortest = Double.MAX_VALUE;
        String shortestPlace = " ";

        System.out.println(startNode); // debug
        System.out.print("Max-Double-Value: ");
        usedPlaces[0] = startNode;
        for (int i = 0; i < length; i++) {
            System.out.println(valueOfShortest);
            System.out.println(shortestPlace);
            if (getLengthOfTwoCoordinates(tsp1.getOrtX(0), tsp1.getOrtY(0), tsp1.getOrtX(i), tsp1.getOrtY(i)) < valueOfShortest) { // statisch
                valueOfShortest = getLengthOfTwoCoordinates(tsp1.getOrtX(0), tsp1.getOrtY(0), tsp1.getOrtX(i), tsp1.getOrtY(i));
                shortestPlace = tsp1.getOrtName(i);
            }
            usedPlaces[i + 1] = shortestPlace; // [i + 1] alle stellen nach startNode


            // in liste aufnehmen used
            // "shortest"-knoten zu startnode machen
        }
        /*
        // debugging stuff
        System.out.println(valueOfShortest);
        System.out.println(shortestPlace);
        */
    }

    public static void greedyAlgorithm(Journey tsp1) {
        int length = tsp1.places.size();
        String[] usedPlaces = new String[length];

        String startNode = tsp1.getOrtName(0);
        usedPlaces[0] = startNode;
        double totalLength = 0.0;
        int currentIndex = 0;

        for (int mainIndex = 0; mainIndex < length - 1; mainIndex++) {
            double shortestDistance = Double.MAX_VALUE;
            int nextIndex = -1;

            for (int littleIndex = 0; littleIndex < length; littleIndex++) {
                if (!Arrays.asList(usedPlaces).contains(tsp1.getOrtName(littleIndex))) {
                    double distance = getLengthOfTwoCoordinates(tsp1.getOrtX(currentIndex), tsp1.getOrtY(currentIndex), tsp1.getOrtX(littleIndex), tsp1.getOrtY(littleIndex));
                    if (distance < shortestDistance) {
                        shortestDistance = distance;
                        nextIndex = littleIndex;
                    }
                }
            }

            totalLength += shortestDistance;
            usedPlaces[mainIndex + 1] = tsp1.getOrtName(nextIndex);
            currentIndex = nextIndex;
        }

        totalLength += getLengthOfTwoCoordinates(tsp1.getOrtX(currentIndex), tsp1.getOrtY(currentIndex), tsp1.getOrtX(0), tsp1.getOrtY(0));

        System.out.println("Used positions: " + Arrays.toString(usedPlaces));
        System.out.println("Value of shortest course: " + totalLength);
    }


}