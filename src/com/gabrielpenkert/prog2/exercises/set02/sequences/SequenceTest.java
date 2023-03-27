package com.gabrielpenkert.prog2.exercises.set02.sequences;

public class SequenceTest {

    public static void main(String[] args) {
        int start = 5;
        int end = 20;

        System.out.print("Naturals: ");
        println(new Naturals()); // , ... fehlt noch
        System.out.println();

        //Intervallausgabe
        System.out.print("Range: ");
        println(new Range(start, end)); // Intervalleingabe erforderlich
        System.out.println();
        System.out.println();


        Range range = new Range(start, end); // Intervall geht aus irgendeinem Grund nicht

        //Gerade Zahlenfolge ausgabe
        Filter startEvensFilter = new Evens(range); // instanziierung des Filters zur anschließenden Ausgabe

        System.out.print("Evens: ");
        println(range, startEvensFilter); // Ausgabe

        Filter startZapMultiplesFilter = new ZapMultiplies(range, 3);  // instanziierung des Filters zur
        // anschließenden Ausgabe

        System.out.print("ZapMultiplies: ");
        println(range, startZapMultiplesFilter); // Ausgabe
    }

    public static void println (Naturals instanceOfNaturals) {
        for (int i = 0; i < 10; i++) {
            System.out.print(instanceOfNaturals.intArray[i]);
            if (i == 9 || i == instanceOfNaturals.intArray.length - 1) {
                System.out.print(", ...");
                break;
            }
            System.out.print(", ");
        }

    }
    public static void println(Range range) {
        int start = range.startOfIntervall;
        int end = range.endOfIntervall;

        while (start != end) {
            System.out.print(range.intArray[start]);
            if (start < end - 1)
                System.out.print(", ");
            start++;
        }
    }

    /*
    public static void println(Sequence sequence, Filter filter) {
        int i = 0;
        while (sequence.hasNext(i)) {
            if (filter.condition(i))
                System.out.print(i + ", ");
            i++;
        }
        System.out.print("Endzahl (nicht zutreffend/geprueft): " + i);
        System.out.println();
    }
    */
    public static void println(Range range, Filter filter) {
        int i = range.startOfIntervall;
        while (range.hasNext(i) && i < range.endOfIntervall) {
            if (filter.condition(i))
                System.out.print(i + ", ");
            if (i == range.endOfIntervall - 1)
                System.out.print(" ...");
            i++;
        }
        System.out.println();
    }
}