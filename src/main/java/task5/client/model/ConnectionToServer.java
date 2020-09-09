package task5.client.model;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Objects;

public class ConnectionToServer {
    final String host;
    final int port;
    final String username;
    final Socket socket;
    final ObjectOutputStream objectOutputStream;

    public ConnectionToServer(String host, int port, String username, Socket socket, ObjectOutputStream objectOutputStream) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.socket = socket;
        this.objectOutputStream = objectOutputStream;
    }
}
