package com.cunningbird;

public class Main {

    public static void main(String[] args) {
        DocumentQueue documents = new DocumentQueue(5);

        Feeder feeder = new Feeder(documents);
        Printer printer1 = new Printer(documents, "Printer One");
        Printer printer2 = new Printer(documents, "Printer Two");
        Printer printer3 = new Printer(documents, "Printer Three");

        feeder.start();
        printer1.start();
        printer2.start();
        printer3.start();
    }
}