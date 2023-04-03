/* Gabriel Penkert, Programmieren 2
* Wenn man bei der TSP-Auswahl mal beispielsweise "4" (als Integer) eingibt, dann bricht das Programm nach der zweiten
* Eingabe ab, egal welcher Wert es ist. Den Fehler habe ich nicht mehr gefunden. Wenn Du ihn findest wäre es schön,
* wenn du mir sagen könntest, wo er ist (oder mir vielleicht einen kleinen Tipp geben könntest).
* Ansonsten (wenn man ganz normal eine Zahl wischen 1 & 3 eingibt) funktioniert der Greedy-Algorithmus mit allen
* drei Beispielen.
*
* Mit freundlichen Grüßen,
* Gabriel
*/



package com.gabrielpenkert.prog2.exercises.set03;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        int input = inputGetter();
        startTSP(input);
    }

    public static int inputGetter () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welches TSP möchten Sie (mit dem Greedy-Algorithmus) lösen lassen?");
        System.out.print("Eingabe (1-3): ");
        try {
            int input = Integer.parseInt(scanner.nextLine());
            if (input == 1 || input == 2 || input == 3)
                return input;
        } catch (Exception e) {
            System.out.println("Ein Fehler ist aufgetreten.");
            inputGetter();
        }
        return 0;
    }
    public static void startTSP (int input) {
        if (input == 1) {
            Journey tsp1 = new Journey();
            tsp1.addOrt(new Place("A", 2, 1));
            tsp1.addOrt(new Place("B", 1, 1));
            tsp1.addOrt(new Place("C", 2, 2));
            tsp1.addOrt(new Place("D", 1, 2));
            tsp1.addOrt(new Place("E", 2, 3));
            tsp1.addOrt(new Place("F", 1, 3));
            TSP.greedyAlgorithm (tsp1);
        } else if (input == 2) {
            Journey tsp1 = new Journey();
            tsp1.addOrt(new Place("A", 7, 1));
            tsp1.addOrt(new Place("B", 6, 1));
            tsp1.addOrt(new Place("C", 5, 1));
            tsp1.addOrt(new Place("D", 4, 1));
            tsp1.addOrt(new Place("E", 6, 2));
            tsp1.addOrt(new Place("F", 5, 2));
            tsp1.addOrt(new Place("G", 7, 4));
            tsp1.addOrt(new Place("H", 4, 4));
            tsp1.addOrt(new Place("I", 3, 4));
            tsp1.addOrt(new Place("J", 2, 4));
            tsp1.addOrt(new Place("K", 1, 4));
            TSP.greedyAlgorithm (tsp1);
        } else if (input == 3) {
            Journey tsp1 = new Journey();
            tsp1.addOrt(new Place("A", 7, 1));
            tsp1.addOrt(new Place("B", 6, 1));
            tsp1.addOrt(new Place("C", 5, 1));
            tsp1.addOrt(new Place("D", 4, 1));
            tsp1.addOrt(new Place("E", 6, 2));
            tsp1.addOrt(new Place("F", 5, 2));
            tsp1.addOrt(new Place("G", 7, 4));
            tsp1.addOrt(new Place("H", 4, 4));
            tsp1.addOrt(new Place("I", 3, 4));
            tsp1.addOrt(new Place("J", 2, 4));
            tsp1.addOrt(new Place("K", 1, 4));
            tsp1.addOrt(new Place("L", 7, 5));
            tsp1.addOrt(new Place("M", 4, 5));
            tsp1.addOrt(new Place("N", 3, 5));
            tsp1.addOrt(new Place("O", 2, 5));
            TSP.greedyAlgorithm (tsp1);
        } else {
            System.out.println("Ein Fehler ist aufgetreten.");
            inputGetter();
        }
    }

    //region alte sachen - hab's davor mit normalen Arrays versucht
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