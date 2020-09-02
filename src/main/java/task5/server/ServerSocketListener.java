package task5.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketListener implements Runnable {
    private ServerSocket serverSocket;
    private ServerConnections serverConnections;

    public ServerSocketListener(ServerSocket serverSocket, ServerConnections serverConnections) {
        this.serverSocket = serverSocket;
        this.serverConnections = serverConnections;
    }

    @Override
    public void run() {
        //TODO: этот класс слушает и ждет новые подключения к серверу - нужно в цикле принимать (.accept)
        // сокеты с сервер сокета и каждый сокет посылать в ServerConnection на обработку
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                serverConnections.processNewSocket(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
