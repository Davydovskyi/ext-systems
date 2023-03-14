package edu.jcourse.net;

import java.io.*;
import java.lang.reflect.Constructor;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket socket = new ServerSocket(25225)) {

            Map<String, Greetable> handlers = loadHandlers();

            System.out.println("server is started");
            while (true) {
                Socket client = socket.accept();
                new SimpleServer(client, handlers).start();
            }
        }
    }

    //TODO add logger
    private static Map<String, Greetable> loadHandlers() {
        Map<String, Greetable> result = new HashMap<>();

        try (InputStream is = Server.class.getClassLoader().getResourceAsStream("server.properties")) {
            Properties properties = new Properties();
            properties.load(is);

            for (Object command : properties.keySet()) {
                String className = properties.getProperty(command.toString());
                Class<?> clazz = Class.forName(className);

                Constructor<?> constructor = clazz.getDeclaredConstructor();
                Object handler = constructor.newInstance();
                result.put(command.toString(), (Greetable) handler);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return result;
    }
}

//TODO add logger
class SimpleServer extends Thread {

    private final Socket client;
    private Map<String, Greetable> handlers;

    public SimpleServer(Socket client, Map<String, Greetable> handlers) {
        this.client = client;
        this.handlers = handlers;
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

            String response = buildResponse(command, userName);
            writer.write(response);
            writer.newLine();
            writer.flush();
            client.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    private String buildResponse(String command, String userName) {
        if (handlers.containsKey(command)) {
            return handlers.get(command).buildResponse(userName);
        }
        return "Not supported yet";
    }

    @Override
    public void run() {
        handleRequest();
    }
}
