package com.company.exercise1;
import java.util.Scanner;

public class exercise1 {
    public static void ConnectFourRun() {
        Runtime();
    }
    public static boolean gameActive = true;
    public static int roundCounter = 1;
    public static Scanner myObj = new Scanner(System.in);
    public static String[][] placements = {
            {".",".",".",".",".","."},
            {".",".",".",".",".","."},
            {".",".",".",".",".","."},
            {".",".",".",".",".","."},
            {".",".",".",".",".","."},
            {".",".",".",".",".","."},
            {".",".",".",".",".","."}
    };
    public static void Runtime(){

        while (true) { // game loop
            if (roundCounter % 2 != 0)
                System.out.println("Player X!");
            else
                System.out.println("Player O!");
            printBoard();
            if (isVerticalWinProof() || isHorizontalWinProof() || isDiagonalWinProofDown() || (roundCounter == 43)){
                System.out.println("Game Over!");
                break;
            }
            System.out.print("Enter slot: ");
            System.out.println();
            String slotString = myObj.nextLine(); // instantiate scanner
            int slotInt = Integer.parseInt(slotString); // converts String to Int
            // System.out.println("Slot used: " + slotInt);
            getInput(slotInt);
            roundCounter++;
        }
    }
    public static void getInput(int usedSlot) { // input is set
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
    public static void printBoard() {
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

    public static boolean isHorizontalWinProof() {
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
    public static boolean isVerticalWinProof() { // deutsch noch auf englisch konvertieren
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
    public static boolean isDiagonalWinProofDown() {
        boolean thereIsAWinner = false;
        for (int zeile = 0; zeile <= 3; zeile++) { // durchläuft iterativ die drei obersten zeilen/ebenen
            switch (zeile) {
                case 0:
                    boolean possibility0 = true;
                    String letterAtPos0 = placements[zeile][0]; // erster Wert der aktuellen zeile/ebene
                    for (int spalte = 0; spalte <= 2; spalte++) {
                        if (letterAtPos0 != placements[spalte + zeile][spalte]) {
                            possibility0 = false;
                            break;
                        }
                    }
                    if (possibility0 && letterAtPos0 != ".")
                        thereIsAWinner = true;
                    break;
            }
        }
        return thereIsAWinner;
    }
}