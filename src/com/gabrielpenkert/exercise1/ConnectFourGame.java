/*
* Gabriel Penkert, Programmieren 2, Abgabe 1
*
* Habe leider etwas an Redundanz im Code. Gerade mit der ConnectFourRun() und der Runtime()-Methode hätte man das
* natürlich auch eleganter lösen können. Aber für meinen persönlichen Durchblick wollte ich das so gestalten.
* Was die Überprüfung der die Gewinnmöglichkeiten betrifft habe ich das sicherlich sehr umständlich gelöst. Einige
* Kommilitonen haben mir ihren Ansatz geschildert, den ich auch einfach eleganter finde. Wollte an meinem Code jatzt
* aber kurz vor der Abgabe nicht nochmals alles umschreiben. Ich bitte um Nachsicht - dankeschön!
* */

package com.gabrielpenkert.exercise1;
import java.util.Scanner;

public class ConnectFourGame {
    public void ConnectFourRun() {
        Runtime();
    }
    public int roundCounter = 1;
    public Scanner myObj = new Scanner(System.in);
    public String[][] placements = {
            {".",".",".",".",".","."},
            {".",".",".",".",".","."},
            {".",".",".",".",".","."},
            {".",".",".",".",".","."},
            {".",".",".",".",".","."},
            {".",".",".",".",".","."},
            {".",".",".",".",".","."}
    };
    public void Runtime(){

        while (true) { // game loop
            if (roundCounter % 2 != 0)
                System.out.println(coloredText("Green", "Player X's turn!"));
            else
                System.out.println(coloredText("Green", "Player O's turn!"));
            printBoard();
            if (isVerticalWinProof() || isHorizontalWinProof() || isDiagonalWinProofUp() || isDiagonalWinProofDown() || (roundCounter == 43)){
                if (roundCounter % 2 != 0)
                    System.out.println(coloredText("Green", "Player O wins!"));
                else
                    System.out.println(coloredText("Green", "Player X wins!"));
                System.out.println(coloredText("Blue", "Game Over!"));
                break;
            }
            System.out.print("Slot: ");
            System.out.println();
            int slotInt = 0;
            try {
                String slotString = myObj.nextLine(); // instantiate scanner
                slotInt = Integer.parseInt(slotString); // converts String to Int
                if (slotInt < 0 || slotInt > 6) {
                    System.out.println("Ungültige Eingabe! Bitte eine Zahl zwischen 0 und 6 Wählen!");
                    slotString = myObj.nextLine();
                    slotInt = Integer.parseInt(slotString); // converts String to Int
                }
                getInput(slotInt);
                roundCounter++;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                coloredText("Red", "Bitte eine gültige Zahl eingeben!");
            }
        }
    }
    public void getInput(int usedSlot) { // input is set
        for (int i = 5; i >= 0; i--) {
            if (placements[usedSlot][i] == ".") {
                if (roundCounter % 2 != 0)
                    placements[usedSlot][i] = "X";
                else
                    placements[usedSlot][i] = "O";
                break;
            }
            if (i == 0) {
                System.out.println("Ungültige Eingabe! Bitte wiederholen!");
                roundCounter--;
                String slotString = myObj.nextLine(); // instantiate scanner
                int slotInt = Integer.parseInt(slotString); // converts String to Int
                System.out.println("Slot used: " + slotInt);
                getInput(slotInt);
            }
        }
    }
    public void printBoard() {
        System.out.println("00 01 02 03 04 05 06");
        System.out.println("--------------------");
        System.out.println(placements[0][0] + "  " + placements[1][0] + "  " + placements[2][0] + "  " + placements[3][0] + "  " + placements[4][0] + "  " + placements[5][0] + "  " + placements[6][0]);
        System.out.println(placements[0][1] + "  " + placements[1][1] + "  " + placements[2][1] + "  " + placements[3][1] + "  " + placements[4][1] + "  " + placements[5][1] + "  " + placements[6][1]);
        System.out.println(placements[0][2] + "  " + placements[1][2] + "  " + placements[2][2] + "  " + placements[3][2] + "  " + placements[4][2] + "  " + placements[5][2] + "  " + placements[6][2]);
        System.out.println(placements[0][3] + "  " + placements[1][3] + "  " + placements[2][3] + "  " + placements[3][3] + "  " + placements[4][3] + "  " + placements[5][3] + "  " + placements[6][3]);
        System.out.println(placements[0][4] + "  " + placements[1][4] + "  " + placements[2][4] + "  " + placements[3][4] + "  " + placements[4][4] + "  " + placements[5][4] + "  " + placements[6][4]);
        System.out.println(placements[0][5] + "  " + placements[1][5] + "  " + placements[2][5] + "  " + placements[3][5] + "  " + placements[4][5] + "  " + placements[5][5] + "  " + placements[6][5]);
        System.out.println("--------------------");
    }

    public boolean isHorizontalWinProof() {
        boolean thereIsAWinner = false;
        for (int zeileReal = 0; zeileReal <= 5; zeileReal++) {
            for (int spalte = 0; spalte <= 3; spalte++) {
                switch (spalte) {
                    case 0:
                        boolean possibilityOne = true;
                        String letterAtPos0 = placements[0][zeileReal];
                        for (int i = 1; i <= 3; i++) {
                            if (letterAtPos0 != placements[i][zeileReal]) {
                                possibilityOne = false;
                                break;
                            }
                        }
                        if (possibilityOne && letterAtPos0 != ".")
                            thereIsAWinner = true; // gets the function the result to return
                        break;
                    case 1:
                        boolean possibilityTwo = true;
                        String letterAtPos1 = placements[1][zeileReal];
                        for (int i = 2; i <= 4; i++) {
                            if (letterAtPos1 != placements[i][zeileReal]) {
                                possibilityTwo = false;
                                break;
                            }
                        }
                        if (possibilityTwo && letterAtPos1 != ".")
                            thereIsAWinner = true;
                        break;
                    case 2:
                        boolean possibilityThree = true;
                        String letterAtPos2 = placements[2][zeileReal];
                        for (int i = 3; i <= 5; i++) {
                            if (letterAtPos2 != placements[i][zeileReal]) {
                                possibilityThree = false;
                                break;
                            }
                        }
                        if (possibilityThree && letterAtPos2 != ".")
                            thereIsAWinner = true;
                        break;
                    case 3:
                        boolean possibilityFour = true;
                        String letterAtPos3 = placements[3][zeileReal];
                        for (int i = 4; i <= 6; i++) {
                            if (letterAtPos3 != placements[i][zeileReal])
                                possibilityFour = false;
                        }
                        if (possibilityFour && letterAtPos3 != ".")
                            thereIsAWinner = true;
                        break;
                }


                /*
                for (int count = 0; count <= 4; count++) { // my attempt to optimize this crap
                    boolean possibility = true;
                    String letterAtPointedPosition = placements[count][zeileReal];
                    for (int i = (count + 1); i <= (count + 3); i++) {
                        if (letterAtPointedPosition != placements[i][zeileReal])
                            possibility = false;
                        break;
                    }
                    if (possibility && letterAtPointedPosition != ".") {
                        thereIsAWinner = true;
                    }
                    break;
                }
                */

            }
        }
        return thereIsAWinner;
    }
    public boolean isVerticalWinProof() { // deutsch noch auf englisch konvertieren
        boolean thereIsAWinner = false;
        for (int spalte = 0; spalte <= 6; spalte++) {
            for (int zeileReal = 0; zeileReal <= 2; zeileReal++) { // counts the real lines up to the line of index 2
                switch (zeileReal) {
                    case 0:
                        boolean possibilityOne = true;
                        String letterAtPos5 = placements[spalte][5];
                        for (int i = 4; i >= 2; i--) { // 3 weitere oberhalb von pos. 5
                            if (letterAtPos5 != placements[spalte][i]) {
                                possibilityOne = false;
                                break;
                            }
                        }
                        if (possibilityOne  && letterAtPos5 != ".")
                            thereIsAWinner = true; // gets the function the result to return
                        break;
                    case 1:
                        boolean possibilityTwo = true;
                        String letterAtPos4 = placements[spalte][4];
                        for (int i = 3; i >= 1; i--) {
                            if (letterAtPos4 != placements[spalte][i]) {
                                possibilityTwo = false;
                                break;
                            }
                        }
                        if (possibilityTwo && letterAtPos4 != ".")
                            thereIsAWinner = true;
                        break;
                    case 2:
                        boolean possibilityThree = true;
                        String letterAtPos3 = placements[spalte][3];
                        for (int i = 2; i >= 0; i--) {
                            if (letterAtPos3 != placements[spalte][i]) {
                                possibilityThree = false;
                                break;
                            }
                        }
                        if (possibilityThree && letterAtPos3 != ".")
                            thereIsAWinner = true;
                        break;
                }
            }
        }
        return thereIsAWinner; //...maybe
    }
    public boolean isDiagonalWinProofDown() {
        boolean thereIsAWinner = false;
        for (int i = 0; i <= 2; i++) { // verschiebung an y-achse
            for (int apfel = 0; apfel <= 3; apfel++) { // verschiebung an der x-achse
                // System.out.println("apfel: " + apfel); // debugging

                switch (apfel) {
                    case 0:
                        boolean possibility0 = true;
                        String letterAtPos0 = placements[apfel][i]; // erster Wert der aktuellen zeile/ebene
                        // System.out.println(letterAtPos0);  // debugging
                    /*
                    [i][0] -> [1][0] i = 1, bleibt gleich ; spalte++;
                        [i + spalte][spalte] -> [2][1]
                            [i + spalte][spalte] -> [3][2]
                                [i + spalte][spalte] -> [4][3]
                    */

                        for (int banane = 0; banane <= 3; banane++) {
                            // System.out.println("vergleich mit " + "[" + (banane + apfel) + "]" + "[" + (banane + i) + "]");  // debugging
                            if (letterAtPos0 != placements[banane + apfel][banane + i]) {
                                possibility0 = false;
                                break;
                            }
                        }
                        if (possibility0 && letterAtPos0 != ".")
                            thereIsAWinner = true;
                        break;
                    case 1:
                        boolean possibility1 = true;
                        String letterAtPos1 = placements[apfel][i];
                        // System.out.println(letterAtPos1);  // debugging
                        for (int banane = 0; banane <= 3; banane++) {
                            // System.out.println("vergleich mit " + "[" + (banane + apfel) + "]" + "[" + (banane + i) + "]"); // debugging
                            if (letterAtPos1 != placements[banane + apfel][banane + i]) {
                                possibility1 = false;
                                break;
                            }
                        }
                        if (possibility1 && letterAtPos1 != ".")
                            thereIsAWinner = true;
                        break;
                    case 2:
                        boolean possibility2 = true;
                        String letterAtPos2 = placements[apfel][i];
                        // System.out.println(letterAtPos2); // debugging
                        for (int banane = 0; banane <= 3; banane++) {
                            // System.out.println("vergleich mit " + "[" + (banane + apfel) + "]" + "[" + banane + "]"); // debugging
                            if (letterAtPos2 != placements[banane + apfel][banane + i]) {
                                possibility2 = false;
                                break;
                            }
                        }
                        if (possibility2 && letterAtPos2 != ".")
                            thereIsAWinner = true;
                        break;
                    case 3:
                        boolean possibility3 = true;
                        String letterAtPos3 = placements[apfel][i];
                        // System.out.println(letterAtPos3); // debugging
                        for (int banane = 0; banane <= 3; banane++) {
                            // System.out.println("vergleich mit " + "[" + (banane + apfel) + "]" + "[" + (banane + i) + "]"); // debugging
                            if (letterAtPos3 != placements[banane + apfel][banane + i]) {
                                possibility3 = false;
                                break;
                            }
                        }
                        if (possibility3 && letterAtPos3 != ".")
                            thereIsAWinner = true;
                        break;
                }
            }
        }
        return thereIsAWinner;
    }
    public boolean isDiagonalWinProofUp() {
        boolean thereIsAWinner = false;
        for (int apfel = 0; apfel <= 3; apfel++) { // verschiebung an der x-achse
            // System.out.println("apfel: " + apfel);

            switch (apfel) {
                case 0:
                    boolean possibility0 = true;
                    String letterAtPos0 = placements[apfel][5]; // erster Wert der aktuellen zeile/ebene
                    int counter0 = apfel;
                    for (int banane = 5; banane >= 2; banane--) { // int banane = 4 präziser (optimierung)
                        // System.out.println("vergleich mit " + "[" + (counter0) + "]" + "[" + (banane) + "]");
                        if (letterAtPos0 != placements[counter0][banane]) {
                            possibility0 = false;
                            break;
                        }
                        counter0++;
                    }
                    if (possibility0 && letterAtPos0 != ".")
                        thereIsAWinner = true;
                    break;
                case 1:
                    boolean possibility1 = true;
                    String letterAtPos1 = placements[apfel][5]; // erster Wert der aktuellen zeile/ebene
                    int counter1 = apfel;
                    for (int banane = 5; banane >= 2; banane--) { // int banane = 4 präziser (optimierung)
                        // System.out.println("vergleich mit " + "[" + (counter1) + "]" + "[" + (banane) + "]");
                        if (letterAtPos1 != placements[counter1][banane]) {
                            possibility1 = false;
                            break;
                        }
                        counter1++;
                    }
                    if (possibility1 && letterAtPos1 != ".")
                        thereIsAWinner = true;
                    break;
                case 2:
                    boolean possibility2 = true;
                    String letterAtPos2 = placements[apfel][5]; // erster Wert der aktuellen zeile/ebene
                    int counter2 = apfel;
                    for (int banane = 5; banane >= 2; banane--) { // int banane = 4 präziser (optimierung)
                        // System.out.println("vergleich mit " + "[" + (counter2) + "]" + "[" + (banane) + "]");
                        if (letterAtPos2 != placements[counter2][banane]) {
                            possibility2 = false;
                            break;
                        }
                        counter2++;
                    }
                    if (possibility2 && letterAtPos2 != ".")
                        thereIsAWinner = true;
                    break;
                case 3:
                    boolean possibility3 = true;
                    String letterAtPos3 = placements[apfel][5]; // erster Wert der aktuellen zeile/ebene
                    int counter3 = apfel;
                    for (int banane = 5; banane >= 2; banane--) { // int banane = 4 präziser (optimierung)
                        // System.out.println("vergleich mit " + "[" + (counter3) + "]" + "[" + (banane) + "]");
                        if (letterAtPos3 != placements[counter3][banane]) {
                            possibility3 = false;
                            break;
                        }
                        counter3++;
                    }
                    if (possibility3 && letterAtPos3 != ".")
                        thereIsAWinner = true;
                    break;
                }

            }
        return thereIsAWinner;
    }

    private String coloredText(String Color, String Text) {
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";

        switch (Color) {
            case "Green":
                return String.format("%s%s%s", ANSI_GREEN, Text, ANSI_RESET);
            case "Red":
                return String.format("%s%s%s", ANSI_RED, Text, ANSI_RESET);
            case "Blue":
                return String.format("%s%s%s", ANSI_BLUE, Text, ANSI_RESET);
            case "Yellow":
                return String.format("%s%s%s", ANSI_YELLOW, Text, ANSI_RESET);
        }
        return "";
    }
}