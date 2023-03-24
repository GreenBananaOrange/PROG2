package com.gabrielpenkert.prog2.exercises.set02.sequences;

public class Range implements Sequence {
    public int startOfIntervall;
    public int endOfIntervall;

    public Range (int start, int end) {
        this.startOfIntervall = start;
        this.endOfIntervall = end + 1;
    }

    int[] intArray = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

    @Override
    public boolean hasNext(int i) {
        return false;
    }

    @Override
    public int nextElement() {
        return 0;
    }
}
