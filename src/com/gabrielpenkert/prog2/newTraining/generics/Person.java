package com.gabrielpenkert.prog2.newTraining.generics;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}
