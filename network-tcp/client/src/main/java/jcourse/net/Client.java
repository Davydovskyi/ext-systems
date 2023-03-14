package jcourse.net;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleClient(i).start();
        }
    }
}

//TODO add logger
class SimpleClient extends Thread {

    private static final String[] COMMAND = {"HELLO", "MORNING", "DAY", "EVENING"};
    private final int cmdNumber;

    public SimpleClient(int cmdNumber) {
        this.cmdNumber = cmdNumber;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket("127.0.0.1", 25225);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            String command = COMMAND[cmdNumber % COMMAND.length];

            String name = "Anton";
            writer.write(command + " " + name);
            writer.newLine();
            writer.flush();

            String answer = reader.readLine();
            System.out.println("client got string: " + answer);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
