package edu.jcourse.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket socket = new ServerSocket(25225)) {
            System.out.println("server is started");
            while (true) {
                Socket client = socket.accept();
                new SimpleServer(client).start();
            }
        }
    }
}

//TODO add logger
class SimpleServer extends Thread {

    private final Socket client;

    public SimpleServer(Socket client) {
        this.client = client;
    }

    private void handleRequest() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {

            String request = reader.readLine();
            String[] strings = request.split("\\s+");

            String command = strings[0];
            String userName = strings[1];
            System.out.println("server got string 1: " + command);
            System.out.println("server got string 2: " + userName);

            StringBuilder response = new StringBuilder("Hello, ");
            response.append(userName);
            writer.write(response.toString());
            writer.newLine();
            writer.flush();
            client.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void run() {
        handleRequest();
    }
}
