package com.gabrielpenkert.prog2.exercises.set04;

public class Main {
    public static void main (String[] args) {
        Train santaFe =  new Train(); // zug wird initialisiert

        Car car1 = new Car(12, 50);
        Car car2 = new Car(15, 75);
        Car car3 = new Car(20, 100);

        Locomotive bigChief = new Locomotive("Big Chief", 23, 5311); // lokomotive generieren
        Train.ListElement element = santaFe.insert(bigChief); // lokomotive an zug "anhaengen"
        santaFe.insert(car1);
        santaFe.insert(car2);
        santaFe.insert(car3);
        System.out.println(santaFe.toString());
    }
}
