package com.gabrielpenkert.prog2.exercises.set03;

public class Main {

    public static void main (String[] args) {
        Journey tsp1 = new Journey();
        tsp1.addOrt(new Place("A", 2, 1));
        tsp1.addOrt(new Place("B", 1, 1));
        tsp1.addOrt(new Place("C", 2, 2));
        tsp1.addOrt(new Place("D", 1, 2));
        tsp1.addOrt(new Place("E", 2, 3));
        tsp1.addOrt(new Place("F", 1, 3));
        System.out.println(tsp1.getOrte());
        System.out.println(tsp1.getOrt(2));
    }

    //region auch alte sachen
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
    //endregion
}