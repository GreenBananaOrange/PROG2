package com.gabrielpenkert.prog2.training;

import java.util.*;

public class ContainsDublicateLecture {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("A", "B", "C", "D"));
        System.out.println(containsDublicateByProfessorLunde(list)); // true expected
        System.out.println(containsDublicateByProfessorLunde(list.subList(0, 4))); // from 0 to 2
    }

    private static boolean containsDublicate(List<String> list) {
        HashSet<String> dublicates = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            dublicates.add(list.get(i));
        }
        if (dublicates.size() >= list.size())
            return false;
        return true;
    }
    private static boolean containsDublicate2(List<String> list) {
        List<String> dublicates = new ArrayList<>();
        for (String element : list) {
            if (dublicates.contains(element)) {
                System.out.println(element + " in dublicates enthalten");
                System.out.print("Dublikat: ");
                return true;
            }
            System.out.println(element + " hinzugefügt");
            dublicates.add(element);
        }
        System.out.print("Dublikat: ");
        return false;
    }
    public static boolean containsDublicateByProfessorLunde (List<String> list) { // soll dublikat erkennen - nochmal
        // mit Rufus durchgehen
        Set<String> dublicates = new HashSet<>();
        for (String element : list) {
            /*
            if (dublicates.contains(element))
                return true;
                dublicates.add(element);
            */
            if (!dublicates.add(element))
                return true;
        }
        return false;
    }
}
