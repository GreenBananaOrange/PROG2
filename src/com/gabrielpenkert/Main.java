package com.gabrielpenkert;

import com.gabrielpenkert.prog2.exercises.set02.sequences.Naturals;
import com.gabrielpenkert.prog2.exercises.set02.sequences.Range;
import com.gabrielpenkert.prog2.exercises.set02.sequences.Sequence;
import com.gabrielpenkert.prog2.exercises.set02.sequences.SequenceTest;
import com.gabrielpenkert.prog2.lectureScripts.arraylistsExercise2;
import com.gabrielpenkert.prog2.exercises.set02.exercise2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Dog> list = new ArrayList<Dog>();

        list.add(new Dog("Shaggy", 3));
        list.add(new Dog("Lacy", 2));
        list.add(new Dog("Roger", 10));
        list.add(new Dog("Tommy", 4));
        list.add(new Dog("Tammy", 1));
        Collections.sort(list);

        for(Dog a: list)   // printing the sorted list of names
            System.out.print(a.getDogName() + ", ");
        System.out.println();

        // Sorts the array list using comparator
        Collections.sort(list, new Dog());
        System.out.println(" ");

        for(Dog a: list)   // printing the sorted list of ages
            System.out.print(a.getDogName() +": "+ a.getDogAge() + ",   ");

    }

    static class Dog implements Comparator<Dog>, Comparable<Dog> {
        private String name;
        private int age;
        Dog() {
        }

        Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getDogName() { // getter
            return name;
        }

        public int getDogAge() { // getter
            return age;
        }

        // Overriding the compareTo method
        public int compareTo(Dog dog) {
            return (this.name).compareTo(dog.name);
        }

        // Overriding the compare method to sort the age
        public int compare(Dog dog1, Dog dog2) {
            return dog1.age - dog2.age;
        }
    }

}