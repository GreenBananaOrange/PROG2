package com.gabrielpenkert.prog2.exercises.set05;

public class CuboidTank extends Tank{
    private double x;
    private double y;
    private double z;

    public double vol; // in m3
    public double sur; // in m2

    public CuboidTank (double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getVol() {
        Calculate c = new Calculate(x, y, z);
        vol = c.vol;
        return vol;
    }

    public double getSur() {
        Calculate c = new Calculate(x, y, z);
        sur = c.sur;
        return sur;
    }

    public String toString() {
        return String.format("Cylindrical Tank (x = %.2f, y = %2f, z = %2f)", x, y, z);
    }
}
