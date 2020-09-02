package task5.server;

import task5.messages.ClientMessage;
import task5.messages.ServerMessage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ServerConnections {
    private final int port;
    private final Map<String, ConnectionToClient> connections = new HashMap<>();
    private ServerSocket serverSocket;
    private ServerSocketListener serverSocketListener;
    private final ServerLogic serverLogic;

    public ServerConnections(int port, ServerLogic serverLogic){
        this.port = port;
        this.serverLogic = serverLogic;
    }

    public String generateSessionId(){ return UUID.randomUUID().toString();}

    public synchronized void processNewSocket(Socket socket){
        String sessionID = generateSessionId();
        ConnectionToClient connectionToClient = new ConnectionToClient(sessionID, socket, this);
        connections.put(sessionID, connectionToClient);
        connectionToClient.start();
    }

    public void processMessageFromClient(String sessionId, ClientMessage message){
        serverLogic.acceptMessage(sessionId, message);
    }

    public synchronized void closeConnection(String sessionId){
        ConnectionToClient connectionToClient = connections.get(sessionId);
        if (connectionToClient != null) {
            connectionToClient.close();
            connections.remove(sessionId);
        }
        serverLogic.unregisterClient(sessionId);
    }

    public synchronized void sendMessageToClient(String sessionId, ServerMessage serverMessage){
        //TODO: отправка сообщения конкретному клиенту
        if (connections.get(sessionId) != null)
            connections.get(sessionId).sendMessage(serverMessage);
        else System.out.println("wrong session ID");
    }

    public synchronized void sendMessageToAllClients(ServerMessage serverMessage){
        connections.forEach((s, connectionToClient) -> connectionToClient.sendMessage(serverMessage));
    }

    public void openSocket() throws IOException {
        //инициализация вынесена в отдельный метод потому что нам нужно сначала создать все компоненты (Connections, Logic)
        //связать их друг с другом и только потом открывать сокет, иначе если придет подключение пока все это не готово
        //будет проблема (см ServerMain.main)
        serverSocket = new ServerSocket(port);
        serverSocketListener = new ServerSocketListener(serverSocket, this);
        new Thread(serverSocketListener).start(); //запуск потока который слушает новые подключения
    }

    public synchronized void close() throws IOException {
        serverSocket.close();
        connections.values().forEach(connectionToClient -> connectionToClient.close());
    }

}
