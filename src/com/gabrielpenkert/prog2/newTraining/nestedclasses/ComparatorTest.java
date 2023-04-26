package com.gabrielpenkert.prog2.newTraining.nestedclasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class ComparatorTest {

    public static void main(String[] args) {
        List<ZooTier> tiere = new ArrayList<>();
        tiere.add(new ZooTier("Flatter", "Papageientaucher", "Island"));
        tiere.add(new ZooTier("Heather", "Hochlandrind", "Schottland"));
        tiere.add(new ZooTier("Aki", "Husky", "Finnland"));

        tiere.sort(new NameComparator());
        for (ZooTier tier : tiere)
            System.out.println(tier.name);

        class GattungsComparator implements Comparator<ZooTier> {
            public int compare(ZooTier o1, ZooTier o2) {
                return o1.gattung.compareTo(o2.gattung);
            }
        }
        tiere.sort(new GattungsComparator());
        for (ZooTier tier : tiere)
            System.out.println(tier.gattung);

        tiere.sort(new Comparator<ZooTier>() {
            public int compare(ZooTier o1, ZooTier o2) {
                return o1.herkunft.compareTo(o2.herkunft);
            }
        });
        for (ZooTier tier : tiere)
            System.out.println(tier.herkunft);

        // with lambda:
        tiere.sort((o1, o2) -> o1.herkunft.compareTo(o2.herkunft));

        tiere.sort((ZooTier o1, ZooTier o2) -> { return o1.herkunft.compareTo(o2.herkunft); });

        tiere.sort(Comparator.comparing(o -> o.herkunft));

        // klassischer Methodenaufbau
        for (ZooTier tier : tiere)
            System.out.println(tier.getName());

        // Moderner Methodenaufbau mit Streams
        tiere.stream().forEach(tier -> System.out.println(tier.toString()));
        tiere.forEach(tier -> System.out.println(tier.toString()));


    }

    public static class NameComparator implements Comparator<ZooTier> {
        public int compare(ZooTier o1, ZooTier o2) {
            return o1.name.toLowerCase().compareTo(o2.name.toLowerCase());
        }
    }

    public static class ZooTier {
        final String name;
        final String gattung;
        final String herkunft;

        public ZooTier(String name, String gattung, String herkunft) {
            this.name = name;
            this.gattung = gattung;
            this.herkunft = herkunft;
        }

        public String getName() {
            return name;
        }

        public String toString() {
            return "Name: " + name + ", Gattung: " + gattung + ", Herkunft: " + herkunft;
        }
    }
}
