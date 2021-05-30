package com.cunningbird;

import java.util.*;

public class DocumentQueue {

    private final Queue<Document> queue;

    private final Set<Printer> readers;

    private Set<Printer> whoReadCurrent;

    private final int size;

    public DocumentQueue(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        this.whoReadCurrent = new HashSet<>();
        this.readers = new HashSet<>();
    }

    public void subscribe(Printer printer) {
        readers.add(printer);
    }

    public synchronized void add(Document element) {
        while (queue.size() > size) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        queue.add(element);
        notifyAll();
    }

    public synchronized Document read(Printer printer) {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        if (everyReaderReadFile()) {
            whoReadCurrent = new HashSet<>();
            queue.remove();
        }
        whoReadCurrent.add(printer);
        notify();
        return queue.element();
    }

    private boolean everyReaderReadFile() {
        return whoReadCurrent.equals(readers);
    }
}
