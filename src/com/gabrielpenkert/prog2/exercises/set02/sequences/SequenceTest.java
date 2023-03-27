package com.gabrielpenkert.prog2.exercises.set02.sequences;

public class SequenceTest {

    public static void main(String[] args) {
        System.out.print("Range(3,6): ");
        println(new Range(3,6)); // Intervalleingabe erforderlich
        System.out.println();
        Sequence range = new Range(7, 14);

        Filter evensFilter = new Evens(range);
        System.out.print("Evens: ");
        println(range, evensFilter);

        Filter zapMultiplesFilter = new ZapMultiplies(range, 3);
        System.out.print("ZapMultiplies: ");
        println(new Range(7, 14), zapMultiplesFilter);
    }

    public static void println (Naturals instanceOfNaturals) {
        for (int i = 0; i < 10; i++) {
            System.out.print(instanceOfNaturals.intArray[i]);
            if (i == 9 || i == instanceOfNaturals.intArray.length - 1)
                break;
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

    public static void println(Sequence sequence, Filter filter) {
        int i = 0;
        while (sequence.hasNext(i)) {
            if (filter.condition(i))
                System.out.print(i + ", ");
            i++;
        }
        System.out.print(i);
        System.out.println();
    }
}