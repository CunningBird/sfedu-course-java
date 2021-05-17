package com.cunningbird;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File thisFile = new File("C:\\Users\\roman.laptev\\OneDrive\\University\\6_sem\\DV\\file.txt");
        try {
            System.out.println("Reading contents of " + thisFile.getCanonicalPath());
            System.out.println();

            BufferedReader in = new BufferedReader(new FileReader(thisFile));
            String line;

            int lineCounter = 0;
            line = in.readLine();
            do {
                lineCounter++;
                analyzeString(lineCounter, line);
                line = in.readLine();
            } while (line != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void analyzeString(int number, String line) {
        int notEqualsLettersCounter = 0;
        String[] array = line.split(" ");
        for (String word : array) {
            if (!word.isEmpty() && word.charAt(0) != word.charAt(word.length() - 1)) {
                notEqualsLettersCounter++;
            }
        }

        System.out.println(number + " | " + notEqualsLettersCounter);
    }
}
