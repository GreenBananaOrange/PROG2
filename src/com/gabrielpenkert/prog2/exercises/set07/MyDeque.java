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
        queue.removeFirst();
        queue.removeFirst();
        queue.removeFirst();
        queue.removeFirst();
        queue.removeFirst();
    }

    private T[] elements;
    private int index1;
    private int index2;
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
            elements[index1] = element;
            System.out.println("index1: " + index1);
            index1 = (index1 + 1) % (elements.length); // bei Eintrag NACH letztem Element des Arrays, wird durch MOD
            // wieder von vorne begonnen, da der wert des Index und die Länge des Arrays zusammen 0 ergeben
            // -> Kreislauf (somit werden allerdings bereits beschriebene Werte bei Umkreisung überschrieben)
            size++;
        } catch (Exception e) {
            System.out.println("Ein unbekannter Fehler ist aufgetreten: " + e);
        }
    }

    public void removeFirst () {
        if (!isEmpty()) {
            // keine Ahnung man...
        }
    }

    public T removeLast () {
        index1 = (index1 + elements.length - 1) % elements.length;
        T element = elements[index1];
        size--;
        System.out.println("index1 (removeL): " + index1);
        return element;
    }
}
