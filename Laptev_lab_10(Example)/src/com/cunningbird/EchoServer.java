package com.cunningbird;

import java.io.*;
import java.net.*;
import java.util.*;

public class EchoServer {

    private ServerSocket s;

    private final int port;

    public EchoServer(int p) {
        port = p;
    }

    public void connect() {
        try {
            s = new ServerSocket(port);
            System.out.println("Wait ...");
            // wait for client connection
            try (Socket incoming = s.accept(); InputStream inStream = incoming.getInputStream();
                 OutputStream outStream = incoming.getOutputStream()) {
                Scanner in = new Scanner(inStream);
                PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);

                out.println("Hello! Enter BYE to exit.");

                // echo client input
                boolean done = false;
                while (!done && in.hasNextLine()) {
                    String line = in.nextLine();
                    System.out.println("klient tell-" + line);
                    if (line.trim().equals("BYE")) {
                        done = true;
                        out.println("close");
                    } else
                        out.println("Echo: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EchoServer s = new EchoServer(8189);
        s.connect();
    }
}
