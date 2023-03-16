package com.company.exercise1;
import java.util.Scanner;

public class exercise1 {
    public static void ConnectFourRun() {
        Runtime();
    }
    public static boolean gameActive = true;
    public static int roundCounter = 1;
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

        Scanner myObj = new Scanner(System.in);

        while (gameActive) { // game loop
            if (roundCounter == 42)
                gameActive = false; // if game is over
            System.out.println("Round: " + roundCounter);
            if (roundCounter % 2 != 0)
                System.out.println("Player X!");
            else
                System.out.println("Player O!");
            printBoard();
            System.out.print("Enter slot: ");
            String slotString = myObj.nextLine(); // instantiate scanner
            int slotInt = Integer.parseInt(slotString); // converts String to Int
            System.out.println("Slot used: " + slotInt);
            getInput(slotInt);
            if (isVerticalWinProof1()){
                System.out.println("Game Over!");
                gameActive = false;
            }
            roundCounter++;
            System.out.println();
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
                Scanner myObj = new Scanner(System.in);
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

    public static boolean isVerticalWinProof1() {
        String[] proofArray = {".", ",", "!", "?"};
        for (int coloumn = 0; coloumn < 6; coloumn++) {
            for (int line = 3; line >= 0; line--) {
                if (placements[coloumn][line] != ".")
                    proofArray[line] = "someone"; // muss verbessert werden!!
            }
            if (proofArray[0] == proofArray[1] && proofArray[0] == proofArray[2] && proofArray[0] == proofArray[3]) { // if 4 line exists
                return true;
            }
        }
        return false;
    }
}