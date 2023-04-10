package com.gabrielpenkert.prog2.exercises.set04;

public class Main {
    public static void main (String[] args) {
        Train santaFe =  new Train(); // zug wird initialisiert

        Car car1 = new Car(12, 50);
        Car car2 = new Car(15, 75);
        Car car3 = new Car(20, 100);

        // 1-3:
        Locomotive bigChief = new Locomotive("Big Chief", 23, 5311); // lokomotive generieren
        Train.ListElement firstElement1 = santaFe.insert(bigChief); // lokomotive an zug "anhaengen"
        santaFe.insert(car1);
        santaFe.insert(car2);
        santaFe.insert(car3);
        System.out.println(santaFe.toString());

        Car car4 = new Car(13, 60);
        Car car5 = new Car(18, 80);

        // 4-6:
        Locomotive steelHorse = new Locomotive("Steel Horse", 21, 5409); // lokomotive generieren
        Train rioGrandeExpress =  new Train(); // zug wird initialisiert
        Train.ListElement firstElement2 = rioGrandeExpress.insert(steelHorse); // lokomotive an zug "anhaengen"
        rioGrandeExpress.insert(car4);
        rioGrandeExpress.insert(car5);
        System.out.println(rioGrandeExpress.toString());
        System.out.println("Wagons von Santa Fe werden in den Rio Grande Express übernommen:");


        rioGrandeExpress.insert(santaFe.getCar(3));
        rioGrandeExpress.insert(santaFe.getCar(2));
        rioGrandeExpress.insert(santaFe.getCar(1));


        /*
        for (int i = 1; i < 3; i++) {
            rioGrandeExpress.insert(santaFe.getCar(i)); // Wagon hinten = 1, Lokomotive = höchste Zahl
            rioGrandeExpress.insert(santaFe.getCar(i));
            rioGrandeExpress.insert(santaFe.getCar(i));
            // santaFe.remove();
        }
        */

        System.out.println(rioGrandeExpress.toString());
    }
}