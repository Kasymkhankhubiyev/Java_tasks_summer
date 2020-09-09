package task5.server;

import task5.messages.*;

import java.util.*;

public class ServerLogic {
    private ServerConnections serverConnections;
    private final Map<String, String> connectedUsers = new HashMap<>();
    private final List<MessageFromServer> messagesHistory = new ArrayList<>();

    public void setServerConnections(ServerConnections serverConnections) {
        this.serverConnections = serverConnections;
    }

    public synchronized void acceptMessage(String sessionId, ClientMessage clientMessage){
        //TODO: обработка логики входящего сообщения
        // думаю в этом методе стоит только определить какого типа это сообщение, а дальше раскидать
        // обработку конкретных действий по разным методам

        if (clientMessage instanceof RegisterClient) {
            registerClient(sessionId, (RegisterClient) clientMessage);
        } else if (clientMessage instanceof SendMessage)
            messageFromClient(sessionId, (SendMessage) clientMessage);

    }

    public synchronized void registerClient(String sessionId, RegisterClient registerClient) {
        if (connectedUsers.containsValue(registerClient.userName)){
            serverConnections.sendMessageToClient(sessionId,
                    new ServerErrorAnswer("Username " + registerClient.userName + " is already used."));
        } else {
            connectedUsers.put(sessionId, registerClient.userName);
            serverConnections.sendMessageToClient(sessionId,
                    new ClientRegistered(sessionId));
            serverConnections.sendMessageToAllClients(new NewClientConnected(registerClient.userName));
        }
    }

    public synchronized void messageFromClient(String sessionId, SendMessage sendMessage){
        String clientName = connectedUsers.get(sessionId);
        if (clientName != null) {
            MessageFromServer messageFromServer = new MessageFromServer(sendMessage.message, clientName);
            messagesHistory.add(messageFromServer);
            serverConnections.sendMessageToAllClients(messageFromServer);
        }
    }

    public synchronized void unregisterClient(String connectionId){
        if (connectedUsers.containsKey(connectionId)){
            connectedUsers.remove(connectionId);
            serverConnections.closeConnection(connectionId);
        }
    }
}
