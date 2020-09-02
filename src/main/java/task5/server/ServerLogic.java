package task5.server;

import task5.client.Client;
import task5.messages.*;

import java.util.*;

public class ServerLogic {
    private ServerConnections serverConnections;
    private final Map<String, String> connectedUsers = new HashMap<>();
    private final List<MessageFromServer> messagesHistory = new ArrayList<>();

    public void setServerConnections(ServerConnections serverConnections) {
        this.serverConnections = serverConnections;
    }

    public void acceptMessage(String sessionId, ClientMessage clientMessage){
        //TODO: обработка логики входящего сообщения
        // думаю в этом методе стоит только определить какого типа это сообщение, а дальше раскидать
        // обработку конкретных действий по разным методам
    }

    public void registerClient(String sessionId, RegisterClient registerClient) {
        //TODO: этот код нужно немного переписать, здесь поменялась сигнатура метода
        // Нужно ответить клиентам через serverConnection.sendMessageToClient (или его версию для всех)
        //if (connectedUsers.containsValue(registerClient.chatClientName))
          //  serverConnections.sendMessageToClient(connectedUsers.);
//        if (connectedUsers.containsValue(registerClient.chatClientName))
//            return new ServerErrorAnswer("This name is already in use");
//        String sessionId = UUID.randomUUID().toString();
//        connectedUsers.put(sessionId, registerClient.chatClientName);
//        Client client = new Client(registerClient.userName, registerClient.chatClientName, sessionId);
//        serverConnections.addClient(registerClient.userName, sessionId);
//        return new ClientRegistered(sessionId);
    }

    public void messageFromClient(String sessionId, SendMessage sendMessage){
        String clientName = connectedUsers.get(sendMessage.sessionId);
        if (clientName != null) {
            MessageFromServer messageFromServer = new MessageFromServer(sendMessage.message, clientName);
            messagesHistory.add(messageFromServer);
            //TODO: send message to all clients

        }
    }

    public void unregisterClient(String connectionId){
        //TODO: реакция на отключение пользователя
    }
}
