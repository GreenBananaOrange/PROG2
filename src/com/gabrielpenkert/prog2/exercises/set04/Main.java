/* Gabriel Penkert, Programmieren 2, Aufgabenblatt 4
*
* Hallo Herr Hönig,
* leider funktioniert in diesem Projekt nicht alles wie es soll. Es gibt hier und da einige Bugs, für die mir die Zeit
* zum Beheben leider gefehlt hat (wie man anhand des Abgabezeitpunkts feststellen kann). Die Schritte der acht Durchläufe der
* ersten Aufgabe sind problemlos machbar, sowie die zweite Aufgabe komplett.
* Bei der ersten Aufgabe fehlen jedoch einige Methoden, die wir (in Train.java) implementieren sollten
* (revert, relink, removeFirst, und getPassengers).
* Ich bitte um Nachsicht, da ich aufgrund meines Gerichtsverfahrens, wo ich als Zeuge aussagen musste,
* mit dem Stoff (in allen Fächern) hinterher bin. Das ganze Thema ist ziemlich nervenaufreibend - Herr Lunde habe ich
* darüber bereits informiert. Danke für Ihr Verständnis!
*
* Liebe Grüße
* Gabriel Penkert
* */


package com.gabrielpenkert.prog2.exercises.set04;

public class Main {
    public static void main (String[] args) {
        Train santaFe =  new Train(); // zug wird initialisiert

        Car car1 = new Car(12, 50);
        Car car2 = new Car(15, 75);
        Car car3 = new Car(20, 100);

        // 1-3:
        Locomotive bigChief = new Locomotive("Big Chief", 23, 5311); // lokomotive generieren
        santaFe.insert(bigChief); // lokomotive an zug "anhaengen"
        santaFe.insert(car1);
        santaFe.insert(car2);
        santaFe.insert(car3);
        System.out.println("SantaFe:            " + santaFe.toString());
        Car car4 = new Car(13, 60);
        Car car5 = new Car(18, 80);


        // 4-6:
        Locomotive steelHorse = new Locomotive("Steel Horse", 21, 5409); // lokomotive generieren
        Train rioGrandeExpress =  new Train(); // zug wird initialisiert
        rioGrandeExpress.insert(steelHorse); // lokomotive an zug "anhaengen"
        rioGrandeExpress.insert(car4);
        rioGrandeExpress.insert(car5);
        System.out.println("Rio Grande Express: " + rioGrandeExpress.toString());
        System.out.println("Wagons von Santa Fe werden in den Rio Grande Express übernommen:");

        rioGrandeExpress.insert(santaFe.getCar(3)); // Wagon hinten = 1, Lokomotive = höchste Zahl
        rioGrandeExpress.insert(santaFe.getCar(2));
        rioGrandeExpress.insert(santaFe.getCar(1));
        System.out.println("Der gewaehlte Zug verfuegt über Wagons: " + rioGrandeExpress.hasCars(rioGrandeExpress));
        System.out.println("Rio Grande Express: " + rioGrandeExpress.toString());
        int car = 1;
        System.out.println("Der Wagon " + car + " hat " + rioGrandeExpress.getPassengers(rioGrandeExpress) + " Passagiere an Bord.");

        System.out.println("Santa Fe (Big Chief) verfügt über diese Anzahl an Wagons: " + santaFe.getNumOfCars(santaFe));
        // rioGrandeExpress.removeFirst(rioGrandeExpress.getCarAsListElement(rioGrandeExpress.getNumOfCars(rioGrandeExpress)));
        System.out.println("Rio Grande Express (Steel Horse) verfügt über diese Anzahl an Wagons: " + rioGrandeExpress.getNumOfCars(rioGrandeExpress));
        System.out.println("SantaFe:            " + santaFe.toString());
        System.out.println("Rio Grande Express: " + rioGrandeExpress.toString());
    }
}