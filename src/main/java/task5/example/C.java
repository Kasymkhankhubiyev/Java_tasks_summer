package task5.example;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class C {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6666);
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        new Thread(() -> {
            try {
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                while (true) {
                    System.out.println(inputStream.readObject());
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }).start();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            outputStream.writeObject(scanner.nextLine());
            outputStream.flush();
            System.out.println("sent");
        }
    }
}
