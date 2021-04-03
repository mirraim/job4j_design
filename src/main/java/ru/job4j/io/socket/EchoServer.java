package ru.job4j.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean isEnds = false;
            while (!isEnds) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    String response = "";
                    while (!str.isEmpty()) {
                        if (str.startsWith("GET /?msg=Exit")) {
                            isEnds = true;
                        } else if (str.startsWith("GET /?msg=Hello")) {
                            response = "Hello, dear friend";
                        } else if (str.startsWith("GET /?msg=")) {
                            response = getMessage(str);
                        }
                        System.out.println(str);
                        str = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(response.getBytes());
                }
            }
        }
    }

    private static String getMessage(String str) {
        String param = str.split(" ")[1];
        System.out.println(param);
        String[] message = param.split("=");
        return message.length == 2 ? message[1] : "";
    }
}
