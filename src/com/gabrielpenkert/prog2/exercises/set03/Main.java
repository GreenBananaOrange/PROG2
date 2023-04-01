package com.gabrielpenkert.prog2.exercises.set03;

public class Main {

    public static String[][] coordinatesFirstMap = new String[4][5];
    public static String[][] coordinatesSecondMap = new String[7][9];

    public static void main (String[] args) {
        fillMap(coordinatesFirstMap);
        printMap(coordinatesFirstMap);
        System.out.println(journey.getLengthOfTwoCoordinates(1,1,2,3));
        journey.calcualteOptimalRoute(coordinatesFirstMap);
    }

    public static void fillMap (String[][] coordinates) {
        if (coordinates.length == 4) {
            coordinates[1][1] = "B";
            coordinates[1][2] = "D";
            coordinates[1][3] = "F";
            coordinates[2][1] = "A";
            coordinates[2][2] = "C";
            coordinates[2][3] = "E";
        } else if (coordinates.length == 7) {
            // do ex. 2 & 3
        } else {
            System.out.println("Error: No Board to fill");
            return;
        }
    }

    public static void printMap (String[][] coordinates) {
        if (coordinates.length == 4) {
            for (int i = 0; i < coordinates.length; i++) {
                for (int k = 0; k <= 4; k++) {
                    if (coordinates[i][k] != null)
                        System.out.print(coordinates[i][k] + "       ");
                    else
                        System.out.print(coordinates[i][k] + "    ");
                }
                System.out.println();
            }
        } else if (coordinates.length == 7) {
            // do map 2 & 3
        } else {
            System.out.println("Error: No Board to print");
            return;
        }
    }
}