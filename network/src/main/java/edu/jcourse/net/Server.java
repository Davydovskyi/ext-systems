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
                handleRequest(client);
            }
        }
    }

    private static void handleRequest(Socket client) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {
            StringBuilder builder = new StringBuilder("Hello, ");
            String userName = reader.readLine();
            System.out.println("server got string: " + userName);
            builder.append(userName);
            writer.write(builder.toString());
            writer.newLine();
            writer.flush();
            client.close();
        }
    }
}
