package com.gabrielpenkert.prog2.exercises.set04;

import java.util.Arrays;
import java.util.List;

public class Train {

    public static class ListElement {
        private Object data;
        private ListElement next;

        public ListElement(Object data) { // data als Input // Element als Output
            this.data = data;
            next = null;
        }
    }

    public ListElement head;

    public Train () {
        head = null;
    }

    public Train (Object locomotive) { // insert to the beginning
        ListElement newTrain = new ListElement(locomotive);
        head = newTrain;
    }

    public ListElement insert (Object car) { // element am Anfang einfügen
        ListElement newCar = new ListElement(car);
        if (head == null)
            head = newCar;
        else {
            newCar.next = head; // newCar.next zeigt nun auf head - erst danach...
            head = newCar; // ...wird der newCar selbst zum nächsten head und ist somit das letzte Element
        }
        return newCar;
    }

    public ListElement insert (Object data, ListElement previousCar) {
        ListElement newCar = new ListElement(data);
        if (head == null || previousCar == null) { // wenn es kein previous element gibt
            newCar.next = null; // pointer auf null
            head = newCar; // car ist neuer head
        } else { // wenn es schon ein car im zug gibt
            newCar.next = previousCar.next; // newCar pointer auf next car
            previousCar.next = newCar; // previous Car pointer auf newCar, sodass newCar eingefuegt ist :)
        }
        return newCar; // System.out.println(insert(x,y) + " was inserted.");
    }

    public void remove (ListElement previousCar) { // Element danach löschen
        if (previousCar == null && head != null) // wenn es nur ein head (Lokomotive) gibt
            head = head.next; // Lokomotive wird durch wagon ersetzt
        else if (previousCar != null)
            previousCar.next = previousCar.next.next; // vorheriger Car pointet auf uebernaechsten Car - garbagecollect
    }

    public String toString () { // gibt ganzen Train aus
        ListElement checker = head;
        String string = "(";
        while (checker != null && checker.next != null) { // solange es einen  nächsten Car gibt
            string = string + checker.data.toString() + ", "; // string erweitern um ein beliebiges Car
            checker = checker.next;
        }
        if (checker != null) // kein next Car, sodass String abgeschlossen wird
            string = string + checker.data.toString() + ")";
        return string;
    }
}