package com.gabrielpenkert.prog2.exercises.set06;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static int lineCounter = 0;

    public static void main(String[] args) {


        WordFrequencyCounter counter = new WordFrequencyCounter();
        counter.analyzeText(new File("C:/Users/penke/IdeaProjects/PROG2/src/com/gabrielpenkert/prog2/data/Song.txt"));
        counter.printResults();
        System.out.println();

        counter.getAllWordsCounted(new File("C:/Users/penke/IdeaProjects/PROG2/src/com/gabrielpenkert/prog2/data/Song.txt"));

        System.out.println("Anzahl der Wörter: "+ wordCounter(new File("C:/Users/penke/IdeaProjects/PROG2/src/com/gabrielpenkert/prog2/data/Song.txt")));
        System.out.println("Line Count: " + lineCounter);
    }

    public void getAllWordsCounted (File input) {

        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> frequency = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) { // Woerter und anzahl erfassen
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] wordsInLine = line.split("\\s+");
                for (String word : wordsInLine) {
                    if (words.contains(word)) {
                        int index = words.indexOf(word);
                        frequency.set(index, frequency.get(index) + 1);
                    } else {
                        words.add(word);
                        frequency.add(1);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        // woerter und anzahl in Array packen
        ArrayList<WordObject> sortedCountedWords = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {
            sortedCountedWords.add(new WordObject(words.get(i), frequency.get(i)));
        }

        System.out.println();

        int MaxValue = 0;
        for (WordObject object : sortedCountedWords) {
            if (object.getFrequency() > MaxValue)
                MaxValue = object.getFrequency();
        }

        for (int rank = 0; rank < sortedCountedWords.size(); rank++) {
            for (int counter = 0; counter < sortedCountedWords.size(); counter++)
                if (sortedCountedWords.get(counter).frequency == rank)
                    System.out.println(sortedCountedWords.get(counter));
        }

        System.out.println();
        System.out.println("MaxValue: " + MaxValue);

    }

    public static class WordObject {
        String word;
        int frequency;

        public WordObject(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        public String toString () { // leider wird noch ein seltsamer zeilenumbruch erzeugt
            return (word + ": " + frequency);
        }

        public int getFrequency() {
            return frequency;
        }
    }

    public static int wordCounter (File input) {
        File file = input;
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
            System.out.println(e);
        }

        int wordCounter = 0;
        while (scanner.hasNext()) { // where the magic happens
            scanner.next();
            wordCounter++;
        }
        return wordCounter;
    }

    public void analyzeText (File textFile) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(textFile));
            while (true) {
                lineCounter++;
                String currLine = in.readLine();
                if (currLine == null)
                    break;
                // analyzeLine(currLine);
            }
        } catch (IOException ex) {
            System.out.println("Error occurred while reading from " + textFile.getAbsolutePath() + ":");
            System.out.println(ex);
        }
    }

    private void analyzeLine (String line) {
        System.out.println(line);
    }

    public void printResults () {
    }
}