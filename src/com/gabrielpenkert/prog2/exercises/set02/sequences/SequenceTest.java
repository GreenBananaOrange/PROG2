package com.gabrielpenkert.prog2.exercises.set02.sequences;
import java.util.Arrays;

public class SequenceTest {

    public static void main(String[] args) {
        println(new Range(3,6));
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
            System.out.print(", ");
            start++;
        }
    }
}
