package com.gabrielpenkert.prog2.exercises.set03;

import java.util.ArrayList;

public class Journey {
    public ArrayList places = new ArrayList();

    public ArrayList getOrte () {
        return places;
    }

    public void addOrt (Place ort) {
        this.places.add(ort);
    }

    public static double getLengthOfTwoCoordinates (int x1, int y1, int x2, int y2) {
        double length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return length;
    }

    /*
    public static String[] calcualteOptimalRoute (String[][] map) {
        int numberOfPlaces = 0;
        //region counts number of places
        if (map.length == 4) { // map.length is the x-axis
            for (int line = 0; line < map.length; line++) {
                for (int column = 0; column <= 4; column++) { // condition for y-axis is a const.
                    if (map[line][column] != null)
                        numberOfPlaces++;
                }
            }

            System.out.print("numberOfPlaces: " + numberOfPlaces);
        } else if (map.length == 7) {
            // do map 2
        } else {
            System.out.println("Error: No Board to print");
            return null;
        }
        //endregion

        String[] optimalRoute = new String[numberOfPlaces + 1]; // +1 because for buildung a cycle

        //region counts number of places
        if (map.length == 4) { // map.length is the x-axis


            for (int i = 0; i < numberOfPlaces; i++) {
                // calculate the optimal route for map 1
                int shortestX;
                int shortestY;
            }



        } else if (map.length == 7) {
            // do map 2
        } else {
            System.out.println("Error: No Board to print");
            return null;
        }
        //endregion


        return optimalRoute;
    }
    */
    // methode implementieren, die überprüft, ob zeichen nicht null ist
}