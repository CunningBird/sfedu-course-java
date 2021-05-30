package com.cunningbird;

public class Feeder extends Thread  {

    private final DocumentQueue queue;

    public Feeder(DocumentQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("Feeder load element: " + i);
            queue.add(feed(i));
        }
    }

    public Document feed(int id) {
        return new Document(String.valueOf(id), "Some text");
    }
}
