package com.gabrielpenkert.prog2.exercises.set06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        WordFrequencyCounter counter = new WordFrequencyCounter();
        counter.analyzeText(new File("C:/Users/penke/IdeaProjects/PROG2/src/com/gabrielpenkert/prog2/data/Song.txt"));
        counter.printResults();
    }

    public static int lineCounter = 0;

    public void analyzeText(File textFile) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(textFile));
            while (true) {
                String currLine = in.readLine();
                if (currLine == null)
                    break;
                analyzeLine(currLine);
                lineCounter++;
            }
        } catch (IOException ex) {
            System.out.println("Error occurred while reading from " + textFile.getAbsolutePath() + ":");
            System.out.println(ex);
        }
    }
    private void analyzeLine(String line) {
        System.out.println(line);
    }
    public void printResults() {
    }
}