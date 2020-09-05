package task5.server;

import task5.messages.*;

import java.util.*;

public class ServerLogic {
    private final int MESSAGES_TO_RESND = 10;

    private ServerConnections serverConnections;
    private final Map<String, String> connectedUsers = new HashMap<>();
    private final List<MessageBroadcast> messagesHistory = new ArrayList<>();

    public void setServerConnections(ServerConnections serverConnections) {
        this.serverConnections = serverConnections;
    }

    public synchronized void acceptMessage(String sessionId, ClientMessage clientMessage){
        //TODO: обработка логики входящего сообщения
        // думаю в этом методе стоит только определить какого типа это сообщение, а дальше раскидать
        // обработку конкретных действий по разным методам

        if (clientMessage instanceof RegisterClientRequest) {
            registerClient(sessionId, (RegisterClientRequest) clientMessage);
        } else if (clientMessage instanceof SendMessageRequest) {
            messageFromClient(sessionId, (SendMessageRequest) clientMessage);
        } else if (clientMessage instanceof UnregisterClientRequest) {
            unregisterClient(sessionId);
        } else if (clientMessage instanceof ConnectedClientsListRequest) {
            sendConnectedClientsList(sessionId);
        } else if (clientMessage instanceof SendFileRequest) {
            resendFile(sessionId, (SendFileRequest) clientMessage);
        }
    }

    public synchronized void resendFile(String sessionId, SendFileRequest sendFileRequest) {
        String username = connectedUsers.get(sessionId);
        if (username != null) {
            serverConnections.sendMessageToAllClientsExceptOne(sessionId,
                    new FileBroadcast(username, sendFileRequest.fileName, sendFileRequest.data)
            );
        }
    }

    public synchronized void sendConnectedClientsList(String sessionId) {
        serverConnections.sendMessageToClient(sessionId,
                new ConnectedClientsListResponse(new ArrayList<>(connectedUsers.values())));
    }

    public synchronized void registerClient(String sessionId, RegisterClientRequest registerClientRequest) {
        if (connectedUsers.containsValue(registerClientRequest.userName)){
            serverConnections.sendMessageToClient(sessionId,
                    new ServerErrorRespond("Username " + registerClientRequest.userName + " is already used."));
        } else {
            connectedUsers.put(sessionId, registerClientRequest.userName);
            serverConnections.sendMessageToClient(sessionId,
                    new ClientSuccessfulRegistrationResponse(sessionId));
            serverConnections.sendMessageToAllClients(new ClientConnectedBroadcast(registerClientRequest.userName));
            //send last n messages to new client
            messagesHistory.subList(Math.max(0, messagesHistory.size() - MESSAGES_TO_RESND),
                    messagesHistory.size()).forEach(messageBroadcast -> serverConnections.sendMessageToClient(sessionId, messageBroadcast));

        }
    }

    public synchronized void messageFromClient(String sessionId, SendMessageRequest sendMessageRequest){
        String clientName = connectedUsers.get(sessionId);
        if (clientName != null) {
            MessageBroadcast messageBroadcast = new MessageBroadcast(sendMessageRequest.message, clientName);
            messagesHistory.add(messageBroadcast);
            serverConnections.sendMessageToClient(sessionId, new ServerSuccessResponse());
            serverConnections.sendMessageToAllClients(messageBroadcast);
        }
    }

    public synchronized void unregisterClient(String sessionId){
        if (connectedUsers.containsKey(sessionId)){
            String username = connectedUsers.get(sessionId);
            connectedUsers.remove(sessionId);
            serverConnections.sendMessageToClient(sessionId, new ServerSuccessResponse());
            serverConnections.closeConnection(sessionId);
            serverConnections.sendMessageToAllClients(new ClientDisconnectedBroadcast(username));
        }
    }
}
