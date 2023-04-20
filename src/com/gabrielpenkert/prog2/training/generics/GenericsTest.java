package com.gabrielpenkert.prog2.training.generics;

import java.util.*;

public class GenericsTest {

    public static boolean hasEvenSize (Collection<? extends Number> collection) {
    return collection.size() % 2 == 0;
}
    public static void main (String[] args) {
        System.out.println(hasEvenSize(new ArrayList<Integer>()));
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(1);
        l.add(1);
        System.out.println(countOccurrences(l , 1));
    }

    public static int countOccurrences (Collection<?> container, Object element) {
        int result = 0;
        for (Object el : container) {
            if (el.equals(element))
                result++;
        }
        return result;
    }
}
