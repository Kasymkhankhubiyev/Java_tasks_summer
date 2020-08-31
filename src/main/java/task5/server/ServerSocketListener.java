package task5.server;

import java.io.IOException;
import java.net.ServerSocket;

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
    }
}
