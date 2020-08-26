package task5.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class S {
    static class SocketListener implements Runnable{
        Socket from;
        Socket to;

        public SocketListener(Socket from, Socket to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = from.getInputStream();
                OutputStream outputStream = to.getOutputStream();
                while(true){
                    int i = inputStream.read();
                    outputStream.write(i);
                    System.out.println(i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket socket1 = serverSocket.accept();
        System.out.println("1 connected");
        Socket socket2 = serverSocket.accept();
        System.out.println("2 connected");
        new Thread(new SocketListener(socket1, socket2)).start();
        new Thread(new SocketListener(socket2, socket1)).start();
        Thread.sleep(100000000);
        serverSocket.close();
    }
}
