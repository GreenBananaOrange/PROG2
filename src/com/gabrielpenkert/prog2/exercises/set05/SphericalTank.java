package com.gabrielpenkert.prog2.exercises.set05;

public class SphericalTank extends Tank{
    private double r;

    public double vol; // in m3
    public double sur; // in m2

    public SphericalTank (double r) {
        this.r = r;
    }

    public double getVol () {
        Calculate c = new Calculate(r);
        vol = c.vol;
        return vol;
    }

    public double getSur () {
        Calculate c = new Calculate(r);
        sur = c.sur;
        return sur;
    }

    public String toString() {
        return String.format("Spherical Tank (r = %.2f)", r);
    }
}
