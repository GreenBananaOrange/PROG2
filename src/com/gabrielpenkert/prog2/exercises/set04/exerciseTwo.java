package com.gabrielpenkert.prog2.exercises.set04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class exerciseTwo {
    public static List<Integer> createList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    public static void measureTime(Runnable code) {
        long startTime = System.nanoTime();
        code.run();
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns");
    }

    List<Integer> arrayList = new ArrayList<>();
    List<Integer> linkedList = new LinkedList<>();

    int N = 50000;
    /*
    System.out.println("Appending " + N + " elements to the end:");
    measureTime(() -> {
        for (int i = 0; i < N; i++) {
            arrayList.add(i);
        }
    });
    measureTime(() -> {
        for (int i = 0; i < N; i++) {
            linkedList.add(i);
        }
    });
    */
}