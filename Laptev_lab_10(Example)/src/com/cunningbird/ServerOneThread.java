package com.cunningbird;

import java.io.*;
import java.net.*;

public class ServerOneThread extends Thread {

    private final Socket socket;

    private final BufferedReader in;

    private final PrintWriter out;

    public ServerOneThread(Socket s) throws IOException {
        socket = s;
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(
                new BufferedWriter(new OutputStreamWriter(
                        socket.getOutputStream())), true);
        start();
    }

    public void run() {
        try {
            out.println("Hello! Enter END to exit.");
            boolean done = true;
            while (done) {
                String str = in.readLine();
                if (str.equals("BYE")) {
                    out.println("close");
                    done = false;
                    Thread.currentThread().interrupt();
                } else {
                    System.out.println("Echoing: " + str);
                    out.println("ECHO:" + str);
                }
            }
        } catch (IOException e) {
            System.out.println();
        } finally {
            try {
                System.out.println("closing...");
                socket.close();
            } catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }
}
   
