package edu.jcourse.net;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new SimpleClient().start();
        }
    }
}

class SimpleClient extends Thread {
    //TODO add logger
    @Override
    public void run() {
        try (Socket socket = new Socket("127.0.0.1", 25225);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            String name = "Anton";
            writer.write(name);
            writer.newLine();
            writer.flush();

            String answer = reader.readLine();
            System.out.println("client got string: " + answer);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
