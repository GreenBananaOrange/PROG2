package com.gabrielpenkert.prog2.exercises.set02.sequences;

public class Naturals implements Sequence{

    int[] intArray = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

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
    public int nextElement() {
        return 0;
    }
}