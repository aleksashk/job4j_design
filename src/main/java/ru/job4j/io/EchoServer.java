package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        if (str.contains("Hello")) {
                            out.write("\r\n\n".getBytes());
                            out.write("Hello".getBytes());
                        } else if (str.contains("Exit")) {
                            out.write("\r\n\n".getBytes());
                            out.write("Завершить работу сервера.".getBytes());
                            out.close();
                        } else {
                            out.write("\r\n\n".getBytes());
                            out.write("What".getBytes());
                        }
                    }
                    out.flush();
                }
            }
        }
    }
}
