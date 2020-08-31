package task5.server;

import task5.client.Client;
import task5.messages.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ServerConnections {
    private final MessageEncoder messageEncoder;
    private final Map<String, Socket> Sockets = new HashMap<>();
    private final Map<String, String> ClientMap = new HashMap();

    Socket socket = new Socket("127.0.0.1", 6666);
    public String generateSessionId(){ return UUID.randomUUID().toString();}
    private final ServerSocket serverSocket = new ServerSocket(6666);

    public void addSockets(){
        Sockets.put(generateSessionId(),socket);
    }

    public void addClient(String clientName, String sessionID){
        ClientMap.put(clientName,sessionID);
    }

    public String getSessionID(String clientName){
        return ClientMap.get(clientName);
    }

    public void deleteClient(String clientName){
        ClientMap.remove(clientName);
    }
    public Map<String, Socket> getClientSockets() {
        return Sockets;
    }

    public Socket getSocket(String sessionID){
        return Sockets.get(sessionID);
    }

    public ServerConnections(MessageEncoder messageEncoder) throws IOException {
        this.messageEncoder = messageEncoder;
    }
}
