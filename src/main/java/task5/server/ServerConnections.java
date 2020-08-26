package task5.server;

import task5.messages.ClientMessage;
import task5.messages.ServerMessage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerConnections {
    private final MessageEncoder messageEncoder;
    private final Map<String, Socket> clientSockets = new HashMap<>();

    private final ServerSocket serverSocket = new ServerSocket(6666);

    public ServerConnections(MessageEncoder messageEncoder) throws IOException {
        this.messageEncoder = messageEncoder;
    }




}
