package com.gabrielpenkert.prog2.exercises.set05;

public class Calculate {
    public static double vol;
    public double sur;

    public Calculate (double x, double y, double z) { // Cuboid-Calculator
        vol = x * y * z;
        sur = (2 * x * y) + (4 * y * z);
    }

    public Calculate (double r, double h) { // Cylindrical-Calculator
        vol = 3.14 * Math.pow(r, 2) * h;
        sur = 2 * 3.14 * r * (r * h);
    }

    public Calculate (double r) { // Spherical-Calculator
        vol = (4/3) * 3.14 * Math.pow(r, 3);
        sur = 4 * 3.14 * Math.pow(r, 2);
    }
}