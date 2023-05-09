package com.gabrielpenkert.prog2.exercises.set08;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Prints recursively all files which are contained in * the current directory or in sub-directories.
 * @author Reinhard Schiedermeier, Ruediger Lunde
 */

public class FlexibleFileTreeWalker {
    public FileProcessor fileProcessor;

    public static void main(String[] args) throws IOException {
        // FlexibleFileTreeWalker.walk(".");
        // fileProcessor.walk(".");
        new FlexibleFileTreeWalker.LargeFileFinder();
    }

    public FlexibleFileTreeWalker (FileProcessor fileProcessor) {
        this.fileProcessor = fileProcessor;
    }

    interface FileProcessor {
        static void process(File file) throws IOException {
            System.out.printf("%-100s%6d%n", file.getCanonicalPath(), file.length()); // ...wird sie hier geprintet
        }
    }

    public static class LargeFileFinder {
        List<FileData> loadedPaths = new ArrayList<FileData>();

        public LargeFileFinder () throws IOException {
            loadPaths(".");
            sortAndFilterPaths();
            printPaths();
        }

        public void loadPaths (String pathname) throws IOException {
            File[] files = new File(pathname).listFiles();
            if (files != null) {
                for (File file : files)
                    if (file.isDirectory())
                        loadPaths(file.getCanonicalPath());
                    else
                        loadedPaths.add(new FileData(file.length(), file.getCanonicalPath()));
            }
        }

        public void sortAndFilterPaths() {
            Collections.sort(loadedPaths, Comparator.comparing(o -> o.fileSize)); // auf süss

        }

        public void printPaths () {
            for (int i = 0; i < loadedPaths.size(); i++)
                System.out.println("Path: " + loadedPaths.get(i).path + " Size: " + loadedPaths.get(i).fileSize);

        }

        class FileData {
            public Long fileSize;
            public String path;

            public FileData (Long fileSize, String path) {
                this.fileSize = fileSize;
                this.path = path;
            }
        }
    }
}