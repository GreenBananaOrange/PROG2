package com.gabrielpenkert.prog2.exercises.set05;

import java.util.Collection;
import java.util.Iterator;

public class Main {
    public static void main (String[] args) {

        Tank tank1 = new CuboidTank(2, 3, 4);
        Tank tank2 = new CylindricalTank(2, 3);
        Tank tank3 = new SphericalTank(3);
        Tank tank4 = new CuboidTank(1, 2, 3);
        Tank tank5 = new CylindricalTank(1, 2);
        Tank tank6 = new SphericalTank(2);

        CompositeTank compositeTank1 = new CompositeTank();
        compositeTank1.add(tank1);
        compositeTank1.add(tank2);
        compositeTank1.add(tank3);

        CompositeTank compositeTank2 = new CompositeTank();
        compositeTank2.add(tank4);
        compositeTank2.add(tank5);
        compositeTank2.add(tank6);

        compositeTank2.add(tank1);
        compositeTank2.remove(tank1);

        System.out.println("Original: " + compositeTank1.toString());
        System.out.println(compositeTank2.toString());

        CompositeTank clonedCompositedTanks = compositeTank1.clone(); // klone zusammengesetzten tank
        System.out.println("Clone: " + compositeTank1.clone()); // klon ausgeben

        Iterator<Tank> iterator = compositeTank1.iterator();
        while (iterator.hasNext()) { // aus original einen tank loeschen
            Tank condition = iterator.next();
            if (condition instanceof CuboidTank) { // loescht aus Original einen Quader-Tank
                iterator.remove();
                break;
            }
        }

        Iterator<Tank> iterator2 = clonedCompositedTanks.iterator();
        while (iterator2.hasNext()) {
            if (iterator2.next() instanceof CuboidTank) { // ueberpruefung ob Quader-Tank noch enthalten ist
                System.out.println("Klon enthält den gelöschten Tank");
                return;
            } else
                System.out.println("Klon enthält den gelöschten Tank nicht");
        }
    }
}
