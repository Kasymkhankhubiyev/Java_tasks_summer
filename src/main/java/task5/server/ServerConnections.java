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

    public void processNewSocket(Socket socket){
        //TODO: обработка нового сокета который открывает ServerSocketListener
        // здесь нудно создать новый sessionId, новый ConnectionToClient
        // положить ConnectionToClient в Map
        String sessionID = generateSessionId();
        ConnectionToClient connectionToClient = new ConnectionToClient(sessionID, socket, this);
        connections.put(sessionID, connectionToClient);
    }

    public void processMessageFromClient(String sessionId, ClientMessage message){
        //TODO: здесь нужно обработать сообщение от конкретного клиента (сообщение попадает сюда из ConnectionToClient)
        // по сути его нужно просто транслировать в serverLogic так как обработка делается там
        serverLogic.acceptMessage(sessionId,message);
    }

    public void closeConnection(String sessionId){
        //TODO: закрытие клиентского подключения (ConnectionToClient) и удаление его из connections
        connections.get(sessionId).close();
        connections.remove(sessionId);

    }

    public void sendMessageToClient(String sessionId, ServerMessage serverMessage){
        //TODO: отправка сообщения конкретному клиенту
        connections.get(sessionId).sendMessage(serverMessage);
    }

    public void sendMessageToAllClients(ServerMessage serverMessage){
        //TODO: отправка сообщения всем клиентам
        connections.forEach(connectionToClient -> connections.get());
    }

    public void openSocket() throws IOException {
        //инициализация вынесена в отдельный метод потому что нам нужно сначала создать все компоненты (Connections, Logic)
        //связать их друг с другом и только потом открывать сокет, иначе если придет подключение пока все это не готово
        //будет проблема (см ServerMain.main)

        serverSocket = new ServerSocket(port);
        serverSocketListener = new ServerSocketListener(serverSocket, this);
        new Thread(serverSocketListener).start(); //запуск потока который слушает новые подключения
    }

    public void close() throws IOException {
        serverSocket.close();
        connections.values().forEach(connectionToClient -> connectionToClient.close());
    }

}
