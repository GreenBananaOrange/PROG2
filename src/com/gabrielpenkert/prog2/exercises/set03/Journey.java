package com.gabrielpenkert.prog2.exercises.set03;

import java.util.ArrayList;

public class Journey {
    public ArrayList places = new ArrayList();

    public ArrayList getOrte () {
        return places;
    }

    public Object getOrt (int index) {
        return places.get(index);
    }

    public void addOrt (Place ort) {
        places.add(ort);
    }

    public String getOrtName(int index) {
        Place place = (Place) places.get(index);
        return place.getName();
    }
    public int getOrtX(int index) {
        Place place = (Place) places.get(index);
        return place.getX();
    }
    public int getOrtY(int index) {
        Place place = (Place) places.get(index);
        return place.getY();
    }
}