package com.gabrielpenkert.prog2.exercises.set04;

public class Car {
    private final double length;
    private final int passengers;

    public Car(double length, int passengers) {
        this.length = length;
        this.passengers = passengers;
    }

    public String toString() {
        String s = "Car: Length = " + length + ", Passengers = " + passengers;
        return coloredText("Blue", s);
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
