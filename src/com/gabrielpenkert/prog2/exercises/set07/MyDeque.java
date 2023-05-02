package com.gabrielpenkert.prog2.exercises.set07;

public class MyDeque<T> {
    public static void main (String[] args) {
        MyDeque queue = new MyDeque(20);
        queue.addFirst(1); // wird irgendwie nicht in queue mit aufgenommen
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
        queue.addFirst(15);
        queue.addFirst(16);
        queue.addFirst(17);
        queue.addFirst(18);
        queue.addFirst(19);
        queue.addFirst(20);
        queue.addFirst(21); // ab hier beginnt neuer Zyklus
        System.out.println("First element: " + queue.getFirst());
        System.out.println("Last element: " + queue.getLast());
        System.out.println("Vor Bearbeitung: " + queue.toString());

        queue.removeLast();
        queue.addLast(100);

        System.out.println("Last element: " + queue.getLast());
        System.out.println("First element: " + queue.getFirst());
        System.out.println("Nach Bearbeitung: " + queue.toString());
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

    public T get(int i) { // gibt bei 0 als Eingabe den letzten Wert im Buffer zurück
        return elements[i];
    }
    public T getFirst () {
        return elements[0];
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

    public T getLast () {
        try {
            return elements[index2];
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e);
        }
        return null;
    }

    public T removeLast () {
        try {
            T element = elements[index2];
            elements[index2] = null;
            return element;
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e);
        }
        return null;
    }

    public void addLast(T elem) {
        if (!isEmpty())
            elements[size - 2] = elem;
        else {
            int counter = 0;
            for (int i = 0; elements[i] != null; i++) {
                counter++;
            }
            elements[size - counter] = elem;
        }
    }

    public void removeFirst () {
        if (!isEmpty()) {
            elements[0] = null;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        int count = 0;
        int i = 0;
        while (i < elements.length && count < size) {
            int index = (index1 +  i) % elements.length;
            if (elements[index] != null) {
                stringBuilder.append(elements[index].toString());
                count++;
                if (count < size) // habe nicht verstanden, wie ich dieses letzte Leerzeichen wegbekomme -_-
                    stringBuilder.append(" ");
            }
            i++;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}