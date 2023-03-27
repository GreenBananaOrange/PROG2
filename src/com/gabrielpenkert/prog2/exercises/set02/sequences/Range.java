package com.gabrielpenkert.prog2.exercises.set02.sequences;

public class Range implements Sequence {
    public int startOfIntervall;
    public int endOfIntervall;

    public static int arrayLength = 100;
    int[] intArray = new int[arrayLength];

    public Range (int start, int end) {
        this.startOfIntervall = start;
        this.endOfIntervall = end + 1;
        for (int i = 0; i < arrayLength; i++) {
            intArray[i] = i;
        }
    }


    @Override
    public boolean hasNext(int i) {
        try {
            if (intArray[i + 1] >= 0 || intArray[i + 1] < 0)
                return true;
        } catch (Exception exception) {
            return false;
        }
        return false;
    }

    @Override
    public int nextElement(int i) {
        if (hasNext(i))
            return intArray[i + 1];
        System.out.println("No next element included");
        return 0;
    }
}
