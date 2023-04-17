package com.gabrielpenkert.prog2.exercises.set05;

import java.util.Iterator;

public abstract class Tank {
    private double vol;
    private double sur;

    public double getVol (){
        return vol;
    }

    public double getSur () {
        return sur;
    }

    public abstract String toString();
}
