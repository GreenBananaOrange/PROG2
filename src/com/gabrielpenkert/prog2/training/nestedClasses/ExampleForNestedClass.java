package com.gabrielpenkert.prog2.training.nestedClasses;

class Outside {
    int alpha = 0;

    class Inside {
        int beta = 5;
    }
}

public class ExampleForNestedClass {

    public static void main (String[] args) {
        Outside outside = new Outside();
        Outside.Inside inside = outside.new Inside();
        System.out.println(outside.alpha + ", " + inside.beta);
    }
}
