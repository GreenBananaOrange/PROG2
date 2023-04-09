package com.gabrielpenkert.prog2.exercises.set04;

public class Locomotive {
    private final double length;
    private final int type;
    private final String name;

    public Locomotive(String name, double length, int type) {
        this.name = name;
        this.length = length;
        this.type = type;
    }

    public String toString() {
        String s = "Locomotive: Name = " + name + ", Length = " + length + ", Type = " + type;
        return coloredText("Green", s);
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
