package com.gabrielpenkert.prog2.exercises.set05;

public class CylindricalTank extends Tank{
    private double r;
    private double h;

    public double vol; // in m3
    public double sur; // in m2

    public CylindricalTank (double r, double h) {
        this.r = r;
        this.h = h;
    }

    public double getVol () {
        Calculate c = new Calculate(r, h);
        vol = c.vol;
        return vol;
    }

    public double getSur () {
        Calculate c = new Calculate(r, h);
        sur = c.sur;
        return sur;
    }

    public String toString() {
        return String.format("Cylindrical Tank (r = %.2f, h = %2f)", r, h);
    }

    public Tank clone() {
        return new CylindricalTank(r, h);
    }
}
