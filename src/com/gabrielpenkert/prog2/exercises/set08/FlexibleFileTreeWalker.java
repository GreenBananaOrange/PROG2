package com.gabrielpenkert.prog2.exercises.set08;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Prints recursively all files which are contained in * the current directory or in sub-directories.
 * @author Reinhard Schiedermeier, Ruediger Lunde
 */

public class FlexibleFileTreeWalker {
    public FileProcessor fileProcessor;

    public static void main(String[] args) throws IOException {
        FlexibleFileTreeWalker.walk(".");
        // fileProcessor.walk(".");
        new FlexibleFileTreeWalker.LargeFileFinder();
    }

    public FlexibleFileTreeWalker (FileProcessor fileProcessor) {
        this.fileProcessor = fileProcessor;
    }

    public static void walk(String pathname) throws IOException { // hier passiert das wesentliche
        File[] files = new File(pathname).listFiles(); // alle Dateipfade werden geladen und in Filearray gelegt
        if (files != null) { // unnötig?
            for (File file : files) // fuer alle Dateien im Array
                if (file.isDirectory()) // Wenn Ziel nur ein Verzeichnis darstellt, dann:
                    walk(file.getCanonicalPath());
                else // Wenn Ziel tatsaechlich eine Datei ist, dann...
                    FileProcessor.process(file);
        }
    }

    interface FileProcessor {
        static void process(File file) throws IOException {
            System.out.printf("%-100s%6d%n", file.getCanonicalPath(), file.length()); // ...wird sie hier geprintet
        }
    }

    public static class LargeFileFinder {
        HashMap<String, Integer> sortedPaths = new HashMap<>();
        int bitCounter = -1;

        public LargeFileFinder () {

        }

        public void addElement (String path, int sizeOfFile) {
            sortedPaths.put(path, sizeOfFile);
        }
    }
}
