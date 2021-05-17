package com.cunningbird;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        try {
            Path path = Paths.get(args[0]);
            if (!Files.exists(path)) {
                throw new Exception("Directory doesn't exists.");
            }

            if (args[1] == null) {
                throw new Exception("File name not found.");
            }

            File file = new File(path + "\\" + args[1]);

            if (file.exists()) {
                System.out.println("File already exists.");

                File newFile;
                do {
                    newFile = new File(path + "\\" +"file" + Math.random() + ".txt");
                } while (newFile.exists());

                if (!file.renameTo(newFile)) {
                    throw new Exception("Existing file renaming error.");
                }

                System.out.println("Existing file renamed.");

                file = new File(path + "\\" + args[1]);
            } else {
                System.out.println("File doesn't exists.");
            }

            if (!file.createNewFile()) {
                throw new Exception("File creating error.");
            }
            System.out.println("File created.");

            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            System.out.println("File opened.");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            writer.println("Creation date: " + dtf.format(now));

            System.out.println("Information entered into the file.");
            writer.flush();
            writer.close();

            System.out.println("File closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
