package com.gabrielpenkert.prog2.exercises.set05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CompositeTank extends Tank{
    private Collection<Tank> allTanks;

    public CompositeTank () {
        this.allTanks = new ArrayList<>();
    }

    public void add (Tank tank) {
        allTanks.add(tank);
    }

    public void remove (Tank tank) {
        allTanks.remove(tank);
    }

    public double getVol () {
        double volume = 0;
        for (Tank tank : allTanks) {
            volume += tank.getVol();
        }
        return volume;
    }

    public double getSur () {
        double surface = 0;
        for (Tank tank : allTanks) {
            surface += tank.getSur();
        }
        return surface;
    }

    public Iterator<Tank> iterator() {
        return allTanks.iterator();
    }

    public String toString() {
        return String.format("Cylindrical Tank (Gesamtvolumen = %.2f Kubikmeter, GesamtOberflaeche = %2f Quadratmeter)", getVol(), getSur());
    }

    public CompositeTank clone() {
        CompositeTank clonedTank = new CompositeTank();
        for (Tank tank: allTanks) {
            clonedTank.add(tank.clone());
        }
        return clonedTank;
    }
}
