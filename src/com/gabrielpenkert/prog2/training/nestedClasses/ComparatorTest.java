package com.gabrielpenkert.prog2.training.nestedClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class ComparatorTest {
    public static void main (String[] args) {
        List<ZooTier> tiere = new ArrayList<>();
        tiere.add(new ZooTier("Flatter", "Papageientaucher", "Island"));
        tiere.add(new ZooTier("Heather", "Hochlandrind", "Schottland"));
        tiere.add(new ZooTier("Aki", "Husky", "Finnland"));

        tiere.sort(new NameComparator());
        tiere.sort(new GattungComparator());
        for (ZooTier tier : tiere)
            System.out.print(tier.name + " | ");
        System.out.println();
        for (ZooTier tier : tiere)
            System.out.print(tier.gattung + " | ");
        System.out.println();

        // with lambda:
        tiere.sort((o1, o2) -> o1.herkunft.compareTo(o2.herkunft));

        // ebenfalls (mit direktem methodenzugriff) darstellbar als:
        tiere.sort(Comparator.comparing(o -> o.herkunft));

        for (ZooTier tier : tiere)
            System.out.print(tier.herkunft + " | "); // sortiert!
    }

    // man könnte einen default compatator implementieren

    public static class ZooTier {
        final String name;
        final String gattung;
        final String herkunft;

        public ZooTier (String name, String gattung, String herkunft) {
            this.name = name;
            this.gattung = gattung;
            this.herkunft = herkunft;
        }
    }

    public static class NameComparator implements Comparator<ZooTier> {
        public int compare(ZooTier o1, ZooTier o2) {
            return o1.name.toLowerCase().compareTo(o2.name.toLowerCase());
        }
    }

    public static class GattungComparator implements Comparator<ZooTier> {
        public int compare(ZooTier o1, ZooTier o2) {
            return o1.gattung.toLowerCase().compareTo(o2.gattung.toLowerCase());
        }
    }
}
