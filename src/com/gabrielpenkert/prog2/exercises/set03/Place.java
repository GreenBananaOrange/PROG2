package com.gabrielpenkert.prog2.exercises.set03;

public class Place {
    private String name;
    private int x;
    private int y;

    public Place (String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName () {
        return name;
    }

    public int getX () {
        return x;
    }

    public int getY () {
        return y;
    }

    public String toString () {
        return String.format("(%s, %d, %d)", name, x, y);
    }
}
