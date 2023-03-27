package com.gabrielpenkert.prog2.exercises.set02;

import com.gabrielpenkert.prog2.exercises.set02.sequences.Sequence;

public class exercise2 {
        Sequence sqnce = new Sequence() {
            @Override
            public boolean hasNext(int i) {
                return false;
            }

            @Override
            public int nextElement(int i) {
                return 0;
            }
    };
}