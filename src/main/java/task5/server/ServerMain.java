package task5.server;

import java.io.IOException;

public class ServerMain {
    public static void main(String[] args) {
        ServerLogic serverLogic = new ServerLogic();
        ServerConnections serverConnections = new ServerConnections(6666, serverLogic);
        serverLogic.setServerConnections(serverConnections);
        try {
            serverConnections.openSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
