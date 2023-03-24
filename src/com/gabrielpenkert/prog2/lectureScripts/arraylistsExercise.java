package com.gabrielpenkert.prog2.lectureScripts;
import java.util.ArrayList;
import java.util.Scanner;

public class arraylistsExercise {
    public static ArrayList<String> myStrings = new ArrayList<String>();
    public static Scanner scan = new Scanner(System.in);

    public static void add () {
        System.out.println("Provide some names (ArrayList is empty):");
        while (true) {
            String input = scan.nextLine();
            if (input.isEmpty())
                break;
            myStrings.add(input);
        }
    }

    public static void remove (int index) {
        myStrings.remove(index);
    }

    public static String get (int index) {
        String wantedString = get(index);
        return wantedString;
    }
}
