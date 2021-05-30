package com.cunningbird;

import java.util.Objects;

public class Printer extends Thread  {

    private final DocumentQueue queue;

    private final String title;

    public Printer(DocumentQueue documentQueue, String title) {
        this.queue = documentQueue;
        this.title = title;
        queue.subscribe(this);
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            printDocument(queue.read(this));
        }
    }

    public void printDocument(Document document) {
        System.out.println(title + ": " + document.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Printer printer = (Printer) o;
        return title.equals(printer.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
