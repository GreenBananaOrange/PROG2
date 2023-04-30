package com.gabrielpenkert.prog2.exercises.set07;

import java.util.*;

public class MyDeque<T> {
    public static void main (String[] args) {
        MyDeque queue = new MyDeque(14); // (*)
        queue.addFirst(1);
        queue.addFirst(2);
        queue.addFirst(3);
        queue.addFirst(4);
        queue.addFirst(5);

        queue.addFirst(6);
        queue.addFirst(7);
        queue.addFirst(8);
        queue.addFirst(9);
        queue.addFirst(10);

        queue.addFirst(11);
        queue.addFirst(12);
        queue.addFirst(13);
        queue.addFirst(14);
        queue.addFirst(15); // (*) wird nicht inzugefügt, da Array dann bereits voll ist
    }

    private T[] elements;
    private int index1;
    private int index2;
    private int testIndex;
    private int size;

    public MyDeque (int capacity) {
        elements = (T[]) new Object[capacity];
        index1 = 0;
        index2 = elements.length - 1;
    }

    public boolean isEmpty () {
        return size == 0;
    }

    public boolean isFull () {
        return size == elements.length;
    }

    public int getSize () {
        return size;
    }

    public void addFirst (T element) {
        try {
            if (!isFull()) {
                elements[index1] = element;
                index1 += 1;
                testIndex = (testIndex + 1) % elements.length;
                System.out.println("testIndex: " + testIndex);
                size++;
            } else
                System.out.println("Array ist voll! ");
        } catch (Exception e) {
            System.out.println("Ein unbekannter Fehler ist aufgetreten: " + e);
        }
    }
}
