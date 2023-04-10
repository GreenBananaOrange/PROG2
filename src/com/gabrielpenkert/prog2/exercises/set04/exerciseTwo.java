package com.gabrielpenkert.prog2.exercises.set04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class exerciseTwo {
    public static void main (String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        int maxIndex = 50000;
        System.out.println(maxIndex + " Elemente (am Ende der Liste) anhaengen:");
        getTime(new Runnable() { // ArrayList wird getestet
            public void run() {
                for (int i = 0; i < maxIndex; i++) {
                    arrayList.add(i);
                }
            }
        });
        getTime(new Runnable() { // LinkedList wird getestet
            public void run() {
                for (int i = 0; i < maxIndex; i++) {
                    linkedList.add(i);
                }
            }
        });

        System.out.println(maxIndex + " Elemente am Anfang der Liste einfuegen:");
        getTime(new Runnable() { // ArrayList wird getestet
            public void run() {
                for (int i = 0; i < maxIndex; i++) {
                    arrayList.add(0, i);
                }
            }
        });

        getTime(new Runnable() { // LinkedList wird getestet
            public void run() {
                for (int i = 0; i < maxIndex; i++) {
                    linkedList.add(0, i);
                }
            }
        });

        System.out.println(maxIndex + " Elemente abrufen:");

        getTime(new Runnable() { // ArrayList wird getestet
            public void run() {
                for (int i = 0; i < maxIndex; i++) {
                    arrayList.get(i);
                }
            }
        });
        getTime(new Runnable() { // LinkedList wird getestet
            public void run() {
                for (int i = 0; i < maxIndex; i++) {
                    linkedList.get(i);
                }
            }
        });
    }

    public static void getTime(Runnable code) {
        double startTime = System.nanoTime(); // Zeitmessung beginnt
        code.run();
        double endTime = System.nanoTime(); // Zeitmessung endet
        System.out.println("Benoetigte Zeit: " + ((endTime - startTime) / 1000000) + " ms"); // Ausgabe
        // der jeweiligen Messung
    }
}