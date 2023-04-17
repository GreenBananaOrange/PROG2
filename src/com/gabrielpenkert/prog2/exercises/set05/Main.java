package com.gabrielpenkert.prog2.exercises.set05;

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

        System.out.println(compositeTank1.toString());
        System.out.println(compositeTank2.toString());
    }
}
